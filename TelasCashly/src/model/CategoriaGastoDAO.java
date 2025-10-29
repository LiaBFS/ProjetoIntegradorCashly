package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaGastoDAO {
	  public void adicionarCategoriaGasto(CategoriaGasto categoriaGasto) {
	        String sql = "INSERT INTO CategoriaGasto (nome) VALUES (?)";
	        Connection conexao = null;
	        PreparedStatement pstm = null;
	        
	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, categoriaGasto.getNome());
	           
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

	   public void atualizarCategoriaGasto(CategoriaGasto categoriaGasto) {
	        String sql = "UPDATE  categoriaGasto SET nome = ?, WHERE id = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, categoriaGasto.getNome());

	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	        }
	   }



// DELETE - Excluir uma categoria pelo ID
public void excluirCategoriaGasto(int id) {
    String sql = "DELETE FROM CategoriaGasto WHERE id = ?";
    Connection conexao = null;
    PreparedStatement pstm = null;

    try {
        conexao = BancoDeDados.conectar();
        pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	BancoDeDados.desconectar(conexao);
    }
}
}