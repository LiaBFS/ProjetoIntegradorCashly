package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
	
	public void adicionarProjeto(Projeto projeto) {
		String sql = "INSERT INTO Projeto (nome, descricao, valorAtual, dataCriacao, objetivo, usuario_id, categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		
		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstm.setString(1, projeto.getNome());
			pstm.setString(2, projeto.getDescricao());
			pstm.setDouble(3, 0.0);
			
			java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());
			pstm.setDate(4, dataAtual);
			
			pstm.setDouble(5, projeto.getObjetivo());
			pstm.setInt(6, projeto.getUsuarioID());
			
			pstm.setString(7, projeto.getCategoria() != null ? projeto.getCategoria().name() : null);
			
			pstm.executeUpdate();
			
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next()) {
				int curId = rs.getInt(1);
				projeto.setId(curId);
				
				if (projeto.getValorAtual() > 0) {
					criarLancamentoInicial(conexao, curId, projeto.getValorAtual(), dataAtual);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao adicionar projeto: " + e.getMessage());
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (conexao != null) conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void criarLancamentoInicial(Connection conexao, int projetoId, double valorInicial, java.sql.Date data) {
		String sqlLancamento = "INSERT INTO LancamentoFinanceiro (data, valor, projeto_id) VALUES (?, ?, ?)";
		String sqlUpdate = "UPDATE Projeto SET valorAtual = (SELECT COALESCE(SUM(valor), 0) FROM LancamentoFinanceiro WHERE projeto_id = ?) WHERE id = ?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conexao.prepareStatement(sqlLancamento);
			pstm.setDate(1, data);
			pstm.setDouble(2, valorInicial);
			pstm.setInt(3, projetoId);
			pstm.executeUpdate();
			pstm.close();
			
			pstm = conexao.prepareStatement(sqlUpdate);
			pstm.setInt(1, projetoId);
			pstm.setInt(2, projetoId);
			pstm.executeUpdate();
			
			System.out.println("Lançamento inicial criado: R$ " + valorInicial + " para projeto ID " + projetoId);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao criar lançamento inicial: " + e.getMessage());
		} finally {
			try {
				if (pstm != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Projeto> listarProjetos() {
		String sql = "SELECT * FROM Projeto WHERE usuario_id=? ORDER BY dataCriacao DESC";
		List<Projeto> projetos = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, Sessao.getUsuarioLogado().getId());
			
			System.out.println("USUARIO LOGADO: " + Sessao.getUsuarioLogado().getId());
			
			rset = pstm.executeQuery();
			while (rset.next()) {
				Projeto projeto = new Projeto();
				projeto.setId(rset.getInt("id"));
				projeto.setNome(rset.getString("nome"));
				projeto.setDataCriacao(rset.getDate("dataCriacao"));
				projeto.setValorAtual(rset.getDouble("valorAtual"));
				projeto.setObjetivo(rset.getDouble("objetivo"));
				projeto.setDescricao(rset.getString("descricao"));
				projeto.setUsuarioID(rset.getInt("usuario_id"));
				
				String categoriaStr = rset.getString("categoria");
				if (categoriaStr != null && !categoriaStr.isEmpty()) {
					try {
						projeto.setCategoria(CategoriaDeProjeto.valueOf(categoriaStr));
					} catch (IllegalArgumentException e) {
						System.err.println("Categoria inválida no banco: " + categoriaStr);
						projeto.setCategoria(null);
					}
				}
				
				projetos.add(projeto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
		return projetos;
	}
	
	public Projeto buscarProjetoRecente() {
		String sql = "SELECT * FROM projeto WHERE usuario_id=? ORDER BY id DESC LIMIT 1";
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Projeto projeto = null;
		
		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, Sessao.getUsuarioLogado().getId());
			rset = pstm.executeQuery();
			
			if (rset.next()) {
				projeto = new Projeto();
				projeto.setId(rset.getInt("id"));
				projeto.setNome(rset.getString("nome"));
				projeto.setDescricao(rset.getString("descricao"));
				projeto.setDataCriacao(rset.getDate("dataCriacao"));
				projeto.setValorAtual(rset.getDouble("valorAtual"));
				projeto.setObjetivo(rset.getDouble("objetivo"));
				
				String categoriaStr = rset.getString("categoria");
				if (categoriaStr != null && !categoriaStr.isEmpty()) {
					try {
						projeto.setCategoria(CategoriaDeProjeto.valueOf(categoriaStr));
					} catch (IllegalArgumentException e) {
						System.err.println("Categoria inválida no banco: " + categoriaStr);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
		return projeto;
	}
	
	public java.util.Map<String, Double> buscarValoresPorCategoria(int usuarioId) {
		java.util.Map<String, Double> mapa = new java.util.HashMap<>();

		String sql = """
			SELECT categoria, SUM(valorAtual) AS total
			FROM Projeto
			WHERE usuario_id = ?
			GROUP BY categoria
		""";

		try (Connection conexao = BancoDeDados.conectar();
			 PreparedStatement pstm = conexao.prepareStatement(sql)) {

			pstm.setInt(1, usuarioId);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				String categoria = rs.getString("categoria");
				double total = rs.getDouble("total");

				if (categoria == null || categoria.isEmpty()) {
					categoria = "Sem Categoria";
				}

				mapa.put(categoria, total);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mapa;
	}

	public double buscarTotalGeral(int usuarioId) {
		String sql = "SELECT SUM(valorAtual) AS total FROM Projeto WHERE usuario_id = ?";

		try (Connection conexao = BancoDeDados.conectar();
			 PreparedStatement pstm = conexao.prepareStatement(sql)) {

			pstm.setInt(1, usuarioId);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				return rs.getDouble("total");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0.0;
	}
	
	/**
	 * Método para excluir um projeto pelo ID
	 * CORRIGIDO: Deleta os lançamentos primeiro, depois o projeto
	 */
	public boolean excluirProjeto(int projetoId) {
		Connection conexao = null;
		PreparedStatement pstm = null;
		
		try {
			conexao = BancoDeDados.conectar();
			
			// Desabilitar autocommit para usar transação
			conexao.setAutoCommit(false);
			
			// 1. Primeiro deletar todos os lançamentos do projeto
			String sqlLancamentos = "DELETE FROM LancamentoFinanceiro WHERE projeto_id = ?";
			pstm = conexao.prepareStatement(sqlLancamentos);
			pstm.setInt(1, projetoId);
			pstm.executeUpdate();
			pstm.close();
			
			// 2. Depois deletar o projeto
			String sqlProjeto = "DELETE FROM Projeto WHERE id = ?";
			pstm = conexao.prepareStatement(sqlProjeto);
			pstm.setInt(1, projetoId);
			int linhasAfetadas = pstm.executeUpdate();
			
			// Confirmar a transação
			conexao.commit();
			
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			// Em caso de erro, reverter a transação
			if (conexao != null) {
				try {
					conexao.rollback();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			return false;
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (conexao != null) {
					conexao.setAutoCommit(true); // Restaurar autocommit
					conexao.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}