package classesBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LancamentoFinanceiroDAO {
	public void adicionarLancamentoFinanceiro(LancamentoFinanceiro lancamentoFinanceiro) {
        String sql = "INSERT INTO LancamentoFinanceiro (valor, descricao) VALUES (?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;
        
        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setDouble(1, lancamentoFinanceiro.getValor());
            pstm.setString(2, lancamentoFinanceiro.getDescricao());
            
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

