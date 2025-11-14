package controller;

import model.*;
import view.TelaInternaLancamentos;
import view.TelaInternaProjeto;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LancamentoController {
    private TelaInternaLancamentos tela;
    private LancamentoFinanceiroDAO lancamentoDAO;
    private int projetoId;
    private TelaInternaProjeto telaProjeto; // Referência para atualizar a tabela
    private ProjetoController projetoController; // Para chamar método de atualização

    public LancamentoController(TelaInternaLancamentos tela, int projetoId, TelaInternaProjeto telaProjeto, ProjetoController projetoController) {
        this.tela = tela;
        this.projetoId = projetoId;
        this.telaProjeto = telaProjeto;
        this.projetoController = projetoController;
        this.lancamentoDAO = new LancamentoFinanceiroDAO();

        tela.getbtnCancelar().addActionListener(e -> tela.dispose());
        tela.getbtnAdicionar().addActionListener(e -> adicionarLancamento());
    }

    private void adicionarLancamento() {
        try {
            // Validar e pegar valor
            String valorTexto = tela.getTxtValorDoLanamento().getText();
            if (valorTexto.equals("Valor do Lançamento") || valorTexto.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Digite um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double valor = Double.parseDouble(valorTexto);

            // Validar e pegar data
            String dataTexto = tela.getTxtDataDoLanamento().getText();
            if (dataTexto.equals("Data do Lancamento") || dataTexto.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Digite uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Converter String para Date (formato esperado: dd/MM/yyyy)
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false); // Não aceitar datas inválidas
            Date data = formato.parse(dataTexto);

            // Criar objeto LancamentoFinanceiro
            LancamentoFinanceiro novo = new LancamentoFinanceiro(0, data, valor);

            // Adicionar no banco
            lancamentoDAO.adicionarLancamentoFinanceiro(novo, projetoId);

            JOptionPane.showMessageDialog(tela, "Lançamento adicionado com sucesso!");
            
            // Atualizar a tabela na tela do projeto
            if (projetoController != null) {
                projetoController.carregarLancamentosNaTabela();
            }
            
            tela.dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(tela, "Digite um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(tela, "Digite uma data válida no formato dd/MM/yyyy (ex: 25/12/2024).", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tela, "Erro ao adicionar lançamento: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
