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
			pstm.setDouble(3, projeto.getValorAtual());
			
			// Pega a data atual do sistema
			java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());
			pstm.setDate(4, dataAtual);
			
			pstm.setDouble(5, projeto.getObjetivo());
			pstm.setInt(6, projeto.getUsuarioID());
			
			// Salvar a categoria (name() retorna o nome da constante do enum)
			pstm.setString(7, projeto.getCategoria() != null ? projeto.getCategoria().name() : null);
			
			// IMPORTANTE: executeUpdate() deve vir DEPOIS de setar todos os parâmetros
			pstm.executeUpdate();
			
			// Recuperar o ID gerado
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next()) {
				int curId = rs.getInt(1);
				projeto.setId(curId);
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
	
	// READ - Listar todos os projetos
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
				
				// Converter String do banco para Enum
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
				
				// Recuperar categoria
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

                // Tratar categoria nula ou vazia
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


    /**
     * Retorna a soma total de todos os valores (valorAtual) dos projetos do usuário.
     * Usado na TelaRelatorio.
     */
    public double buscarTotalGeral(int usuarioId) {
        String sql = "SELECT SUM(valorAtual) AS total FROM Projeto WHERE usuario_id = ?";

        try (Connection conexao = BancoDeDados.conectar();
             PreparedStatement pstm = conexao.prepareStatement(sql)) {

            pstm.setInt(1, usuarioId);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total"); // retorna 0 se for NULL
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0.0;
    }
}
