package controller;

import model.*;
import view.TelaInternaLancamentos;
import javax.swing.*;
import java.util.List;

public class LancamentoController {

    private TelaInternaLancamentos tela;
    private LancamentoFinanceiroDAO lancamentoDAO = new LancamentoFinanceiroDAO();
   

    public LancamentoController(TelaInternaLancamentos tela) {
        this.tela = tela;
 

        tela.getbtnCancelar().addActionListener(e -> tela.dispose());
        tela.getbtnAdicionar().addActionListener(e -> adicionarLancamento());
    }

//    private void carregarCategorias() {
//        List<CategoriaGasto> categorias = categoriaDAO.listarCategorias();
//        JComboBox<String> combo = tela.getComboBoxCategoria();
//
//        combo.removeAllItems();
//        combo.addItem("Selecione ou digite uma categoria");
//        for (CategoriaGasto cat : categorias) {
//            combo.addItem(cat.getNome());
//        }
//        combo.setSelectedIndex(0);
//    }

    private void adicionarLancamento() {
        try {
            double valor = Double.parseDouble(tela.getTxtValorDoLanamento().getText());
            String data = tela.getTxtDataDoLanamento().getText();
            //Object selected = tela.getComboBoxCategoria().getSelectedItem();
            

            LancamentoFinanceiro novo = new LancamentoFinanceiro(0, null, valor);
            novo.setValor(valor);
            
            lancamentoDAO.adicionarLancamentoFinanceiro(novo);
            JOptionPane.showMessageDialog(tela, "Lançamento adicionado com sucesso!");
            tela.dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(tela, "Digite um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
