package controller;

import model.*;
import view.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LancamentoController {
    private TelaInternaLancamentos tela;
    private LancamentoFinanceiroDAO lancamentoDAO;
    private int projetoId;
    private TelaInternaProjeto telaProjeto; 
    private ProjetoController projetoController; 

    public LancamentoController(TelaInternaLancamentos tela, int projetoId, 
                                TelaInternaProjeto telaProjeto, ProjetoController projetoController) {
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
            // Validar valor
            String valorTexto = tela.getTxtValorDoLanamento().getText();
            if (valorTexto.equals("Valor do Lançamento") || valorTexto.isEmpty()) {
                ValorInvalidoLancamento.mostrar(tela);
                return;
            }
            double valor = Double.parseDouble(valorTexto);

            // Validar data
            String dataTexto = tela.getTxtDataDoLanamento().getText();
            if (dataTexto.equals("Data do Lancamento") || dataTexto.isEmpty()) {
                DataInvalidaLancamento.mostrar(tela);
                return;
            }

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false); 
            Date data = formato.parse(dataTexto);

            LancamentoFinanceiro novo = new LancamentoFinanceiro(0, data, valor);
            lancamentoDAO.adicionarLancamentoFinanceiro(novo, projetoId);

            LancamentoAdicionadoSucesso.mostrar(tela);
            
            if (projetoController != null) {
                projetoController.carregarLancamentosNaTabela();
            }
            
            tela.dispose();

        } catch (NumberFormatException ex) {
            ValorInvalidoLancamento.mostrar(tela);
        } catch (ParseException ex) {
            DataInvalidaLancamento.mostrar(tela);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}