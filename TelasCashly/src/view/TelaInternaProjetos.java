package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import model.Projeto;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TelaInternaProjetos extends JPanel {

	private static final long serialVersionUID = 1L;
	private int linha = 0;
	private JScrollPane scroll_pane;
	private JPanel panel_content;
	private JButton btnNomeProjeto1;
	private JButton btnData;
	private AbstractButton btnDescricao;
	
	// CardLayout components
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JPanel telaSemProjetos;
	private JPanel telaComProjetos;
	
	public static final String CARD_SEM_PROJETOS = "semProjetos";
	public static final String CARD_COM_PROJETOS = "comProjetos";

	/**
	 * Create the panel.
	 */
	public TelaInternaProjetos() {
		setBackground(new Color(216, 178, 184));
		setLayout(new BorderLayout());

		// Inicializar CardLayout
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.setBackground(new Color(216, 178, 184));
		
		// Criar tela COM projetos
		telaComProjetos = new JPanel(new BorderLayout());
		telaComProjetos.setBackground(new Color(216, 178, 184));
		
		scroll_pane = new JScrollPane();
		scroll_pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panel_content = new JPanel();
		panel_content.setBackground(new Color(216, 178, 184));
		panel_content.setLayout(new MigLayout("", "[1390px]", "[175px][175px][175px][175px][175px]"));
		scroll_pane.setViewportView(panel_content);
		
		telaComProjetos.add(scroll_pane, BorderLayout.CENTER);
		
		// Criar tela SEM projetos
		telaSemProjetos = new JPanel();
		telaSemProjetos.setBackground(new Color(216, 178, 184));
		telaSemProjetos.setLayout(new BorderLayout());
		
		JLabel lblSemProjetos = new JLabel("");
		lblSemProjetos.setIcon(new ImageIcon(TelaInternaProjetos.class.getResource("/imgs/OPS2.png")));
		lblSemProjetos.setFont(new Font("Carlito", Font.BOLD, 30));
		lblSemProjetos.setForeground(new Color(255, 245, 234));
		lblSemProjetos.setHorizontalAlignment(JLabel.CENTER);
		telaSemProjetos.add(lblSemProjetos, BorderLayout.CENTER);
		
		// Adicionar os cards ao cardPanel
		cardPanel.add(telaComProjetos, CARD_COM_PROJETOS);
		cardPanel.add(telaSemProjetos, CARD_SEM_PROJETOS);
		
		// Adicionar cardPanel ao painel principal
		add(cardPanel, BorderLayout.CENTER);
	}

	/**
	 * Método para alternar entre os cards
	 */
	public void mostrarCard(String nomeCard) {
		cardLayout.show(cardPanel, nomeCard);
	}
	
	/**
	 * Método para mostrar a tela com projetos
	 */
	public void mostrarTelaComProjetos() {
		mostrarCard(CARD_COM_PROJETOS);
	}
	
	/**
	 * Método para mostrar a tela sem projetos
	 */
	public void mostrarTelaSemProjetos() {
		mostrarCard(CARD_SEM_PROJETOS);
	}

	public JPanel adicionarPainelProjeto(Projeto p) {
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/FundoBtn.png");

		panel_4.setLayout(new MigLayout("", "[266][241,grow][241,grow][][241][][][][][][][241][241][][241][241][241][241][266]", "[grow 25][][][][][][][][grow 10][][][][][][grow 25]"));

		btnNomeProjeto1 = new JButton(p.getNome());
		panel_4.add(btnNomeProjeto1, "cell 4 1");
		btnNomeProjeto1.setOpaque(false);
		btnNomeProjeto1.setForeground(new Color(255, 245, 234));
		btnNomeProjeto1.setFont(new Font("Carlito", Font.BOLD, 35));
		btnNomeProjeto1.setFocusPainted(false);
		btnNomeProjeto1.setContentAreaFilled(false);
		btnNomeProjeto1.setBorderPainted(false);

		btnData = new JButton(p.getDataCriacao().toString());
		panel_4.add(btnData, "cell 15 1");
		btnData.setOpaque(false);
		btnData.setForeground(new Color(153, 131, 116));
		btnData.setFont(new Font("Carlito", Font.PLAIN, 25));
		btnData.setFocusPainted(false);
		btnData.setContentAreaFilled(false);
		btnData.setBorderPainted(false);

		btnDescricao = new JButton(p.getDescricao());
		panel_4.add(btnDescricao, "cell 4 2");
		btnDescricao.setOpaque(false);
		btnDescricao.setForeground(new Color(255, 245, 234));
		btnDescricao.setFont(new Font("Carlito", Font.PLAIN, 25));
		btnDescricao.setFocusPainted(false);
		btnDescricao.setContentAreaFilled(false);
		btnDescricao.setBorderPainted(false);
		
		JButton btnExcluir = new JButton("EXCLUIR PROJETO");
		panel_4.add(btnExcluir, "cell 15 2");
		btnExcluir.setOpaque(false);
		btnExcluir.setForeground(new Color(165, 051, 046));
		btnExcluir.setFont(new Font("Carlito", Font.BOLD, 30));
		btnExcluir.setFocusPainted(false);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		
		// CORREÇÃO: Armazenar o botão de excluir como propriedade do painel
		panel_4.putClientProperty("btnExcluir", btnExcluir);

		panel_content.add(panel_4, "cell 0 "+linha+",grow");
		linha++;
		return panel_4;
	}
	
	/**
	 * Método para resetar a contagem de linhas (útil ao recarregar projetos)
	 */
	public void resetarLinhas() {
		linha = 0;
		panel_content.removeAll();
		panel_content.revalidate();
		panel_content.repaint();
	}

	/**
	 * CORREÇÃO: Buscar o botão de excluir que foi armazenado no painel
	 */
	public JButton getBtnExcluirDoPainel(JPanel painelProjeto) {
		if (painelProjeto == null) {
			return null;
		}
		
		// Recuperar o botão que foi armazenado como propriedade do painel
		Object btnObj = painelProjeto.getClientProperty("btnExcluir");
		
		if (btnObj instanceof JButton) {
			return (JButton) btnObj;
		}
		
		// Fallback: buscar recursivamente por um JButton com o texto "EXCLUIR PROJETO"
		return encontrarBotaoExcluir(painelProjeto);
	}
	
	/**
	 * Método auxiliar para buscar o botão de excluir recursivamente
	 */
	private JButton encontrarBotaoExcluir(Component comp) {
		if (comp instanceof JButton) {
			JButton btn = (JButton) comp;
			if ("EXCLUIR PROJETO".equals(btn.getText())) {
				return btn;
			}
		}
		
		if (comp instanceof java.awt.Container) {
			for (Component child : ((java.awt.Container) comp).getComponents()) {
				JButton resultado = encontrarBotaoExcluir(child);
				if (resultado != null) {
					return resultado;
				}
			}
		}
		
		return null;
	}
}