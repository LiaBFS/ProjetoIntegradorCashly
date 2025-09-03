package classesBanco;

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
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, usuario.getNome());
	            pstm.setString(2, usuario.getEmail());
	            pstm.setString(3, usuario.getSenha());
	            
	            Date dataUtil = new Date(1, 4, 26);
	            pstm.setDate(4, dataUtil);
	            
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

	    // UPDATE - Atualizar um usuário existente
	    public void atualizarUsuario(Usuario usuario) {
	        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, usuario.getNome());
	            pstm.setString(2, usuario.getEmail());
	            pstm.setString(3, usuario.getSenha());
	            pstm.setInt(4, usuario.getId());
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	        }
	    }

	    // DELETE - Excluir um usuário pelo ID
	    public void excluirUsuario(int id) {
	        String sql = "DELETE FROM usuarios WHERE id = ?";
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
	            pstm.setString(2, usuario.getSenha());

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




