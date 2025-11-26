package controller;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import model.RelatorioDAO;
import model.Sessao;
import model.CategoriaDeProjeto;
import view.TelaInternaRelatorio;

public class RelatorioController {

    private TelaInternaRelatorio view;
    private RelatorioDAO dao;

    public RelatorioController(TelaInternaRelatorio view) {
        this.view = view;
        this.dao = new RelatorioDAO();
    }

    /**
     * Carrega os dados reais do banco de dados e atualiza o gráfico
     */
    public void carregarDadosDoRelatorio() {
        // Verifica se há usuário logado
        if (Sessao.getUsuarioLogado() == null) {
            System.err.println("Nenhum usuário logado!");
            carregarDadosMock(); // Fallback para dados mock
            return;
        }

        int usuarioId = Sessao.getUsuarioLogado().getId();

        try {
            // Busca dados do banco
            Map<String, Double> dadosBanco = dao.buscarValoresPorCategoria(usuarioId);
            double totalBanco = dao.buscarTotalGeral(usuarioId);

            // Se não houver dados, mostra mensagem
            if (dadosBanco.isEmpty() || totalBanco == 0) {
                System.out.println("Nenhum lançamento encontrado para o usuário.");
                view.atualizarTotal(0.0);
                return;
            }

            // --- CONVERTE categorias ENUM PARA DESCRICAO AMIGÁVEL ---
            Map<String, Double> dadosConvertidos = new HashMap<>();

            dadosBanco.forEach((categoriaEnum, valor) -> {
                try {
                    CategoriaDeProjeto cat = CategoriaDeProjeto.valueOf(categoriaEnum);
                    dadosConvertidos.put(cat.getDescricao(), valor);
                } catch (Exception e) {
                    // fallback caso algum nome não esteja no enum
                    dadosConvertidos.put(categoriaEnum, valor);
                }
            });

            // Mapa de cores atualizado
            Map<String, Color> cores = obterCoresCategorias();

            // Garante cor para todas as categorias presentes
            dadosConvertidos.keySet().forEach(cat -> {
                if (!cores.containsKey(cat)) {
                    cores.put(cat, new Color(112, 49, 49)); // fallback
                }
            });

            // Atualiza o gráfico com dados convertidos
            view.atualizarGrafico(dadosConvertidos, cores);
            view.atualizarTotal(totalBanco);

            System.out.println("✓ Dados do banco carregados com sucesso");
            System.out.println("Total Geral: R$ " + totalBanco);
            dadosConvertidos.forEach((cat, val) ->
                System.out.println(cat + ": R$ " + val)
            );

        } catch (Exception e) {
            System.err.println("Erro ao carregar dados do relatório: " + e.getMessage());
            e.printStackTrace();
            carregarDadosMock(); // Fallback para dados mock em caso de erro
        }
    }

    /**
     * Retorna o mapa de cores para cada categoria
     */
    private Map<String, Color> obterCoresCategorias() {
        Map<String, Color> cores = new HashMap<>();

        cores.put("Saúde e Bem-Estar", new Color(202, 196, 190));
        cores.put("Bens e Aquisições", new Color(112, 49, 49));
        cores.put("Viagens e Lazer", new Color(207, 114, 116));
        cores.put("Educação e Desenvolvimento", new Color(193, 31, 35));
        cores.put("Reserva Financeira", new Color(165, 51, 46));
        cores.put("Família e Relacionamentos", new Color(229, 175, 177));

        return cores;
    }

    /**
     * Carrega dados mockados (para teste sem banco)
     */
    private void carregarDadosMock() {
        Map<String, Double> dados = new HashMap<>();
        dados.put("Bens e Aquisições", 5500.0);
        dados.put("Viagens e Lazer", 2200.0);
        dados.put("Reserva Financeira", 1100.0);
        dados.put("Educação e Desenvolvimento", 3300.0);
        dados.put("Saúde e Bem-Estar", 550.0);
        dados.put("Família e Relacionamentos", 1500.0);

        Map<String, Color> cores = obterCoresCategorias();
        view.atualizarGrafico(dados, cores);

        double total = dados.values().stream().mapToDouble(v -> v).sum();
        view.atualizarTotal(total);

        System.out.println("⚠ Usando dados mock (nenhum dado no banco)");
    }

    public TelaInternaRelatorio getView() {
        return view;
    }
}
