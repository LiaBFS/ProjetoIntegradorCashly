package controller;

import view.TelaInternaEscolhaGrafico;
import view.TelaInternaGraficoCategoria;

import javax.swing.JButton;

public class GraficoController {

    private TelaInternaEscolhaGrafico telaEscolha;

    public GraficoController(TelaInternaEscolhaGrafico telaEscolha) {
        this.telaEscolha = telaEscolha;
        configurarEventos();
    } 

    private void configurarEventos() {

        JButton btnCategorias = telaEscolha.getBotaoCategorias();
        JButton btnPlano = telaEscolha.getBotaoPlano();

        btnCategorias.addActionListener(e -> abrirGraficoCategorias());
        btnPlano.addActionListener(e -> abrirGraficoPlano());
    }

    private void abrirGraficoCategorias() {
        new TelaInternaGraficoCategoria().setVisible(true);
    }

    private void abrirGraficoPlano() {
      
        System.out.println("Abrindo gráfico do plano...");
    }
}
