package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import model.ProjetoDAO;
import model.UsuarioDAO;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class TelaInternaCriar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeProjeto;
	private JTextField tfDescricaoProjeto;
	private JButton btnCriar;
	private JTextField tfSaldo;
	private String placeholderNomeProjeto = "Nome do Projeto";
	private String placeholderDescricao = "Descrição do Projeto";
	private String placeholderSaldo = "Saldo Atual Disponível para o Projeto";
	
	private ProjetoDAO projetoDAO;


	/**
	 * Create the panel.
	 */
	public TelaInternaCriar() {
		
		this.projetoDAO = new ProjetoDAO();
		
		
		
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
		
		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoCriarProjeto2.png");
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[18][grow][grow][grow][18]", "[][][grow 55][][grow 15][][grow 15][][grow 15][][grow 55]"));
		
		tfNomeProjeto = new JTextField();
		panel.add(tfNomeProjeto, "cell 2 3,growx");
		tfNomeProjeto.setColumns(10);
		tfNomeProjeto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfNomeProjeto.getText().equals(placeholderNomeProjeto)) {
					tfNomeProjeto.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfNomeProjeto.getText().isEmpty()) {
					tfNomeProjeto.setText(placeholderNomeProjeto);
				}
			}
		});
		
		
		
		tfDescricaoProjeto = new JTextField();
		panel.add(tfDescricaoProjeto, "cell 2 5,growx");
		tfDescricaoProjeto.setColumns(10);
		
		tfDescricaoProjeto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfDescricaoProjeto.getText().equals(placeholderNomeProjeto)) {
					tfDescricaoProjeto.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfDescricaoProjeto.getText().isEmpty()) {
					tfDescricaoProjeto.setText(placeholderNomeProjeto);
				}
			}
		});
		
		
		tfSaldo = new JTextField();
		panel.add(tfSaldo, "cell 2 7,growx");
		tfSaldo.setColumns(10);
		
		
		tfSaldo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfSaldo.getText().equals(placeholderSaldo)) {
					tfSaldo.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfSaldo.getText().isEmpty()) {
					tfSaldo.setText(placeholderSaldo);
				}
			}
		});
		
		
		
		btnCriar = new JButton("Criar");
		panel.add(btnCriar, "cell 2 9,alignx center,growy");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = tfNomeProjeto.getText();
				String descricao = tfDescricaoProjeto.getText();
				String saldo = tfSaldo.getText();
				
				
				
				if (nome.equals(placeholderNomeProjeto) || descricao.equals(placeholderDescricao) || nome.isEmpty() || descricao.isEmpty() || saldo.equals(placeholderSaldo) || saldo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.", "Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
			        return;
			    }
				
		
				model.Projeto novoProjeto = new model.Projeto();
                novoProjeto.setNome(tfNomeProjeto.getText());
                novoProjeto.setDescricao(tfDescricaoProjeto.getText());
                novoProjeto.setDescricao(tfSaldo.getText());
               
                
                
				projetoDAO.adicionarProjeto(novoProjeto);
               
                
				
				
				
				
			}
		});
		
		

	}

}
