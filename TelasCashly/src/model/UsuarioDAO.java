package model;

	import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
	import java.util.List;

	public class UsuarioDAO {

	    // CREATE - Adicionar um novo usuário
		public void adicionarUsuario(Usuario usuario) {
		    String sql = "INSERT INTO usuario (nome, email, senha, dataCadastro) VALUES (?, ?, ?, ?)";
		    Connection conexao = null;
		    PreparedStatement pstm = null;

		    try {
		        conexao = BancoDeDados.conectar();
		        pstm = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		        pstm.setString(1, usuario.getNome());
		        pstm.setString(2, usuario.getEmail());
		        pstm.setString(3, usuario.getSenhaHash());
		        
		        java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());
		        pstm.setDate(4, dataAtual);

		        pstm.executeUpdate(); 

		        ResultSet rs = pstm.getGeneratedKeys();
		        if (rs.next()) {
		            int curId = rs.getInt(1);
		            usuario.setId(curId);
		        }
		   
		        
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
	    // READ - Listar todos os usuários
//	    public List<Usuario> listarUsuarios() {
//	        String sql = "SELECT * FROM usuarios";
//	        List<Usuario> usuarios = new ArrayList<>();
//	        Connection conexao = null;
//	        PreparedStatement pstm = null;
//	        ResultSet rset = null; // Objeto que guarda o resultado da consulta
//
//	        try {
//	            conexao = BancoDeDados.conectar();
//	            pstm = conexao.prepareStatement(sql);
//	            rset = pstm.executeQuery();
//
//	            while (rset.next()) {
//	                Usuario usuario = new Usuario();
//	                usuario.setId(rset.getInt("id"));
//	                usuario.setNome(rset.getString("nome"));
//	                usuario.setEmail(rset.getString("email"));
//	                usuarios.add(usuario);
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	        	BancoDeDados.desconectar(conexao);
//	            // Fechar recursos
//	        }
//	        return usuarios;
//	    }

	    
	    
	    
	    public void atualizarNomeUsuario(Usuario usuario) {
	        String sql = "UPDATE usuario SET nome = ? WHERE id = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, usuario.getNome());
	            pstm.setInt(2, usuario.getId());
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	        }
	    }
	    
	    public void atualizarEmailUsuario(Usuario usuario) {
	        String sql = "UPDATE usuario SET email = ? WHERE id = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, usuario.getEmail());
	            pstm.setInt(2, usuario.getId());
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	        }
	    }


	    // DELETE
	    public boolean excluirUsuario(int id) {
	        String sql = "DELETE FROM usuario WHERE id = ?";
	        
	        try (Connection conexao = BancoDeDados.conectar();
	             PreparedStatement pstm = conexao.prepareStatement(sql)) {

	            pstm.setInt(1, id);
	            int linhasAfetadas = pstm.executeUpdate();
	            return linhasAfetadas > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    

	    // READ - Listar todos os usuários
	    public Usuario pesquisarUsuariosPorEmailSenha(Usuario usuario) {
	        String sql = "SELECT * FROM usuario where usuario.email = ? and usuario.senha = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null; // Objeto que guarda o resultado da consulta 

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, usuario.getEmail());
	            pstm.setString(2, usuario.getSenhaHash());

	            rset = pstm.executeQuery();

	            if (rset.next()) {
	                usuario.setId(rset.getInt("id"));
	                usuario.setNome(rset.getString("nome"));
	                	        return usuario;

	            }
	            else {
	            	return null;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	            // Fechar recursos
	        }
			return null;
	    }
	}




