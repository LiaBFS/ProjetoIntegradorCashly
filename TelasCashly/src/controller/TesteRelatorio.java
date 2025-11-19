package controller;

import javax.swing.JFrame;

import view.TelaRelatorio;

public class TesteRelatorio {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Teste gráfico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        TelaRelatorio tela = new TelaRelatorio();
        frame.add(tela);

        frame.setVisible(true);
    }
}
