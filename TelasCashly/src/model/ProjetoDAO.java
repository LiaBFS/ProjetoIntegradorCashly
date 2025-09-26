package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjetoDAO {
	
	public void adicionarProjeto(Projeto projeto) {
	    String sql = "INSERT INTO Projeto (nome, descricao, saldo, dataCriacao) VALUES (?, ?, ?, ?)";
	    Connection conexao = null;
	    PreparedStatement pstm = null;

	    try {
	        conexao = BancoDeDados.conectar();
	        pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        
	        pstm.setString(1, projeto.getNome());
	        pstm.setString(2, projeto.getDescricao());
	        pstm.setDouble(3, projeto.getSaldo());

	        // pega a data atual do sistema
	        java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());
	        pstm.setDate(4, dataAtual);

	        pstm.executeUpdate();

	        ResultSet rs = pstm.getGeneratedKeys();
	        if (rs.next()) {
	            int curId = rs.getInt(1);
	            projeto.setId(curId);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstm != null) pstm.close();
	            if (conexao != null) conexao.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

}
