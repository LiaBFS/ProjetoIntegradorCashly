package view;

import javax.swing.JPanel;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaInternaEscolhaGrafico extends JPanel {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tela de Gráficos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 800);
            frame.setContentPane(new TelaInternaEscolhaGrafico());
            frame.setVisible(true);
        });
    }

    public TelaInternaEscolhaGrafico() {
        setBackground(new Color(216, 178, 184));
        setLayout(new MigLayout("", "[1118px][537px]", "[88px][552px]"));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(TelaInternaEscolhaGrafico.class.getResource("/imgs/Gráficos.png")));
        add(lblNewLabel, "cell 0 0,alignx left,aligny top");

        JButton Categorias = new JButton("");
        Categorias.setIcon(new ImageIcon(TelaInternaEscolhaGrafico.class.getResource("/imgs/GraficoCategorias.png")));
        add(Categorias, "flowx,cell 0 1,alignx left,aligny center");

        Categorias.setBorderPainted(false);
        Categorias.setContentAreaFilled(false);
        Categorias.setFocusPainted(false);
        Categorias.setOpaque(false);

        JButton Plano = new JButton("");
        Plano.setIcon(new ImageIcon(TelaInternaEscolhaGrafico.class.getResource("/imgs/GráficoPlano.png")));
        add(Plano, "cell 0 1,alignx left,aligny top");

        Plano.setBorderPainted(false);
        Plano.setContentAreaFilled(false);
        Plano.setFocusPainted(false);
        Plano.setOpaque(false);
    }

	public JButton getBotaoCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	public JButton getBotaoPlano() {
		// TODO Auto-generated method stub
		return null;
	}
}
