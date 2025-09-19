package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjetoDAO {
	
	public void adicionarProjeto(Projeto projeto) {
        String sql = "INSERT INTO Projeto (nome, descricao, saldo, dataCriacao) VALUES (?, ?,?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, projeto.getNome());
            pstm.setString(2, projeto.getDescricao());
            pstm.setDouble(3, projeto.getSaldo());
            
            Date dataUtil = new Date(1, 4, 26);
            pstm.setDate(4, dataUtil);
         
            pstm.executeUpdate();
            
            
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
              int curId = rs.getInt(1);
              projeto.setId(curId);
            
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

}
