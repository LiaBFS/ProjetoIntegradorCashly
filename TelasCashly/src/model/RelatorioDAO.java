package model;

import java.util.Map;

public class RelatorioDAO {

    ProjetoDAO projetoDAO = new ProjetoDAO();

    public Map<String, Double> buscarValoresPorCategoria(int usuarioId) {
        return projetoDAO.buscarValoresPorCategoria(usuarioId);
    }

    public double buscarTotalGeral(int usuarioId) {
        return projetoDAO.buscarTotalGeral(usuarioId);
    }
}
