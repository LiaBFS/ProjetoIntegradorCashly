package classesBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaFinanceiraDAO {
	 public void adicionarMetaFinanceira(MetaFinanceira metaFinanceira) {
	        String sql = "INSERT INTO MetaFinanceira (descricao, valorMeta, valorAtual) VALUES (?, ?, ?)";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, metaFinanceira.getDescricao());
	            pstm.setDouble(2, metaFinanceira.getValorMeta());
	            pstm.setDouble(3, metaFinanceira.getValorAtual());
	            
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
	  public void atualizarMetaFinanceira(MetaFinanceira metaFinanceira) {
	        String sql = "UPDATE metaFinanceira SET descricao = ?, valorMeta = ?, valorAtual = ? WHERE id = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	        	 conexao = BancoDeDados.conectar();
		            pstm = conexao.prepareStatement(sql);
		            pstm.setString(1, metaFinanceira.getDescricao());
		            pstm.setDouble(2, metaFinanceira.getValorMeta());
		            pstm.setDouble(3, metaFinanceira.getValorAtual());
		            
		            pstm.executeUpdate();
		            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	        }
	    }


}
