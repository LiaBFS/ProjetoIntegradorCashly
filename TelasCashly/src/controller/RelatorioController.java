package controller;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import view.TelaRelatorio;


  
    
    public class RelatorioController {

        private TelaRelatorio view;

        public RelatorioController(TelaRelatorio view) {
            this.view = view;
        }

  
      
    public void carregarDadosDoRelatorio() {
        // Aqui você chamaria o Model (DAO, banco, etc)
        // Exemplo simples para demonstração:

        Map<String, Double> dados = new HashMap<>();
        dados.put("Bens e Aquisições", 40.0);
        dados.put("Viagens e Lazer", 16.0);
        dados.put("Reserva Financeira", 8.0);
        dados.put("Educação", 24.0);
        dados.put("Eventos", 8.0);
        dados.put("Saúde e Bem-Estar", 4.0);

        Map<String, Color> cores = new HashMap<>();
        cores.put("Bens e Aquisições", new Color(112,49,49));
        cores.put("Viagens e Lazer", new Color(207,114,116));
        cores.put("Reserva Financeira", new Color(165,51,46));
        cores.put("Educação", new Color(165,51,46));
        cores.put("Eventos", new Color(242,151,151));
        cores.put("Saúde e Bem-Estar", new Color(202,196,190));

        view.atualizarGrafico(dados, cores);

        double total = dados.values().stream().mapToDouble(v -> v).sum();
        view.atualizarTotal(total);
    }

	public TelaRelatorio getView() {
		// TODO Auto-generated method stub
		return null;
	}
}
