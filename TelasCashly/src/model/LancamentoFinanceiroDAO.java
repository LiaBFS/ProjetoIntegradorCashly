package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LancamentoFinanceiroDAO {
	
	
	//ainda não ta funcional, as variaveis de Projeto são: private int id;private Date data;private double valor;private boolean status;private String descricao;private CategoriaGasto categoria;
	
	public void adicionarLancamentoFinanceiro(LancamentoFinanceiro lancamentoFinanceiro) {
        String sql = "INSERT INTO LancamentoFinanceiro (valor, data) VALUES (?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;
        
        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setDouble(1, lancamentoFinanceiro.getValor());
            pstm.setDate(2, new java.sql.Date(lancamentoFinanceiro.getData().getTime()));
            
            pstm.executeUpdate();
      
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

