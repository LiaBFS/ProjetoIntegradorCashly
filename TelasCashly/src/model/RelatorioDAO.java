package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class RelatorioDAO {

    private Connection conn;

    public RelatorioDAO(Connection conn) {
        this.conn = conn;
    }

    // Retorna soma dos valores por categoria
    public Map<String, Double> getValoresPorCategoria(int usuarioId) throws SQLException {
        Map<String, Double> dados = new LinkedHashMap<>();

        String sql = """
            SELECT p.categoria, SUM(l.valor) AS total
            FROM Projeto p
            JOIN LancamentoFinanceiro l ON p.id = l.projeto_id
            WHERE p.usuario_id = ?
            GROUP BY p.categoria
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String categoria = rs.getString("categoria");
            double total = rs.getDouble("total");
            dados.put(categoria, total);
        }

        return dados;
    }

    // Retorna o total geral
    public double getTotalGeral(int usuarioId) throws SQLException {
        String sql = """
            SELECT SUM(l.valor) AS total
            FROM Projeto p
            JOIN LancamentoFinanceiro l ON p.id = l.projeto_id
            WHERE p.usuario_id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getDouble("total");
        }
        return 0.0;
    }

	public Map<String, Double> buscarValoresPorCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

	public double buscarTotalGeral() {
		// TODO Auto-generated method stub
		return 0;
	}
}
