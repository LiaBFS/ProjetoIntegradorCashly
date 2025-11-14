package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LancamentoFinanceiroDAO {

    // Adicionar lançamento com projeto_id
    public void adicionarLancamentoFinanceiro(LancamentoFinanceiro lancamentoFinanceiro, int projetoId) {
        String sql = "INSERT INTO LancamentoFinanceiro (valor, data, projeto_id) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setDouble(1, lancamentoFinanceiro.getValor());
            pstm.setDate(2, new java.sql.Date(lancamentoFinanceiro.getData().getTime()));
            pstm.setInt(3, projetoId);

            pstm.executeUpdate();
            
            // Atualizar o valorAtual do projeto
            atualizarValorAtualProjeto(conexao, projetoId);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao adicionar lançamento: " + e.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            BancoDeDados.desconectar(conexao);
        }
    }
    
    // Atualizar valorAtual do projeto somando todos os lançamentos
    private void atualizarValorAtualProjeto(Connection conexao, int projetoId) throws SQLException {
        String sql = "UPDATE Projeto SET valorAtual = " +
                     "(SELECT COALESCE(SUM(valor), 0) FROM LancamentoFinanceiro WHERE projeto_id = ?) " +
                     "WHERE id = ?";
        
        try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
            pstm.setInt(1, projetoId);
            pstm.setInt(2, projetoId);
            pstm.executeUpdate();
        }
    }

    // Listar todos os lançamentos de um projeto
    public List<LancamentoFinanceiro> listarLancamentosPorProjeto(int projetoId) {
        String sql = "SELECT * FROM LancamentoFinanceiro WHERE projeto_id = ? ORDER BY data DESC";
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<LancamentoFinanceiro> lancamentos = new ArrayList<>();

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, projetoId);
            rs = pstm.executeQuery();

            while (rs.next()) {
                LancamentoFinanceiro lancamento = new LancamentoFinanceiro(
                    rs.getInt("id"),
                    rs.getDate("data"),
                    rs.getDouble("valor")
                );
                lancamentos.add(lancamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            BancoDeDados.desconectar(conexao);
        }

        return lancamentos;
    }
    
    // Obter valor total dos lançamentos de um projeto
    public double obterValorTotalProjeto(int projetoId) {
        String sql = "SELECT COALESCE(SUM(valor), 0) as total FROM LancamentoFinanceiro WHERE projeto_id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        double total = 0.0;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, projetoId);
            rs = pstm.executeQuery();

            if (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            BancoDeDados.desconectar(conexao);
        }

        return total;
    }
}
