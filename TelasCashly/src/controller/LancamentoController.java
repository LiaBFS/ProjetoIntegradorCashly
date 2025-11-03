package controller;

import model.*;
import view.TelaInternaLancamentos;
import javax.swing.*;
import java.util.List;

public class LancamentoController {

    private TelaInternaLancamentos tela;
    private LancamentoFinanceiroDAO lancamentoDAO = new LancamentoFinanceiroDAO();
    private CategoriaGastoDAO categoriaDAO = new CategoriaGastoDAO();

    public LancamentoController(TelaInternaLancamentos tela) {
        this.tela = tela;
        carregarCategorias();

        tela.getbtnCancelar().addActionListener(e -> tela.dispose());
        tela.getbtnAdicionar().addActionListener(e -> adicionarLancamento());
    }

    private void carregarCategorias() {
        List<CategoriaGasto> categorias = categoriaDAO.listarCategorias();
        JComboBox<String> combo = tela.getComboBoxCategoria();

        combo.removeAllItems();
        combo.addItem("Selecione ou digite uma categoria");
        for (CategoriaGasto cat : categorias) {
            combo.addItem(cat.getNome());
        }
        combo.setSelectedIndex(0);
    }

    private void adicionarLancamento() {
        try {
            double valor = Double.parseDouble(tela.getTxtValorDoLanamento().getText());
            String data = tela.getTxtDataDoLanamento().getText();
            Object selected = tela.getComboBoxCategoria().getSelectedItem();
            String categoriaNome = selected != null ? selected.toString().trim() : "";

            if (categoriaNome.isEmpty() || categoriaNome.equals("Selecione ou digite uma categoria")) {
                JOptionPane.showMessageDialog(tela, "Selecione ou digite uma categoria válida.");
                return;
            }

            CategoriaGasto categoria = categoriaDAO.buscarPorNome(categoriaNome);
            if (categoria == null) {
                categoria = new CategoriaGasto(0, categoriaNome);
                categoriaDAO.adicionarCategoriaGasto(categoria);
            }

            LancamentoFinanceiro novo = new LancamentoFinanceiro(0, null, valor, false, categoriaNome, categoria);
            novo.setValor(valor);
            novo.setDescricao("Lançamento adicionado");
            novo.setCategoria(categoria);

            lancamentoDAO.adicionarLancamentoFinanceiro(novo);
            JOptionPane.showMessageDialog(tela, "Lançamento adicionado com sucesso!");
            tela.dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(tela, "Digite um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
