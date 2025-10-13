package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	
	//READ - Listar todos os projetos
  public List<Projeto> listarProjetos() {
       String sql = "SELECT * FROM Projeto";
      List<Projeto> projetos = new ArrayList<>();
      Connection conexao = null;
      PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

       try {
           conexao = BancoDeDados.conectar();
           pstm = conexao.prepareStatement(sql);
           rset = pstm.executeQuery();

           while (rset.next()) {
                Projeto projeto = new Projeto();
              projeto.setId(rset.getInt("id"));
               projeto.setNome(rset.getString("nome"));
              //  projeto.setEmail(rset.getString("email"));
              // projeto.add(projeto);
           }
      } catch (SQLException e) {
         e.printStackTrace();
     } finally {
       	BancoDeDados.desconectar(conexao);
             //Fechar recursos
       }
        return projetos;
   }

}
