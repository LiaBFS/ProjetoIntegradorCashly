package classesBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogAcessoDAO {

    public void adicionarLog(LogAcesso log) {
        String sql = "INSERT INTO LogAcesso (usuario_id, dataHora) VALUES (?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, log.getUsuario().getId());
            pstm.setTimestamp(2, new java.sql.Timestamp(log.getDataHora().getTime()));

            pstm.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
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
}
