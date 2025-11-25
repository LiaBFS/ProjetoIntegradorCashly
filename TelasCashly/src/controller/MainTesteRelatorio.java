package controller;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import controller.RelatorioController;
import model.RelatorioDAO;
import view.TelaRelatorio;

public class MainTesteRelatorio {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Cria a janela principal
            JFrame frame = new JFrame("Teste - Relatório de Projetos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 700);
            frame.setLocationRelativeTo(null);

            // Cria a View
            TelaRelatorio view = new TelaRelatorio();

            // Cria o Controller
            RelatorioController controller = new RelatorioController(view);

            // === TESTE 1: Dados Mock (sem banco) ===
            System.out.println("=== TESTE COM DADOS MOCK ===");
            testeComDadosMock(controller);

            // === TESTE 2: Dados do Banco (descomente se tiver banco configurado) ===
            // testeComBancoDados(controller);

            // Adiciona a view ao frame
            frame.add(view);
            frame.setVisible(true);

            System.out.println("✓ Tela carregada com sucesso!");
        });
    }

    /**
     * Teste 1: Carrega dados mockados (sem banco)
     */
    private static void testeComDadosMock(RelatorioController controller) {
        controller.carregarDadosDoRelatorio();
        System.out.println("✓ Dados mock carregados no gráfico");
    }

    /**
     * Teste 2: Carrega dados reais do banco de dados
     * Descomente e configure sua conexão para usar
     */
    private static void testeComBancoDados(RelatorioController controller) {
        try {
            // Configurar sua conexão aqui
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/seu_banco",
                "seu_usuario",
                "sua_senha"
            );

            RelatorioDAO dao = new RelatorioDAO(conn);

            // Busca dados do banco
            Map<String, Double> dadosBanco = dao.buscarValoresPorCategoria();
            double totalBanco = dao.buscarTotalGeral();

            System.out.println("\n=== DADOS DO BANCO ===");
            System.out.println("Total Geral: R$ " + totalBanco);
            dadosBanco.forEach((cat, val) -> 
                System.out.println(cat + ": R$ " + val)
            );

            // Mapa de cores (igual ao do controller)
            Map<String, Color> cores = new HashMap<>();
            cores.put("Bens e Aquisições", new Color(112, 49, 49));
            cores.put("Viagens e Lazer", new Color(207, 114, 116));
            cores.put("Reserva Financeira", new Color(165, 51, 46));
            cores.put("Educação", new Color(165, 51, 46));
            cores.put("Eventos", new Color(242, 151, 151));
            cores.put("Saúde e Bem-Estar", new Color(202, 196, 190));

            // Atualiza a view com dados reais
            controller.getView().atualizarGrafico(dadosBanco, cores);
            controller.getView().atualizarTotal(totalBanco);

            conn.close();
            System.out.println("✓ Dados do banco carregados com sucesso");

        } catch (SQLException e) {
            System.err.println("✗ Erro ao conectar com o banco:");
            e.printStackTrace();
        }
    }
}

/**
 * Script SQL para criar tabela de teste (opcional)
 * Execute no seu MySQL antes de rodar o teste com banco:
 * 
 * CREATE TABLE projetos (
 *     id INT PRIMARY KEY AUTO_INCREMENT,
 *     nome VARCHAR(100),
 *     categoria VARCHAR(50),
 *     valor DECIMAL(10,2)
 * );
 * 
 * INSERT INTO projetos (nome, categoria, valor) VALUES
 * ('Notebook', 'Bens e Aquisições', 3500.00),
 * ('Smartphone', 'Bens e Aquisições', 2000.00),
 * ('Curso de Inglês', 'Educação', 1500.00),
 * ('Livros', 'Educação', 500.00),
 * ('Viagem Europa', 'Viagens e Lazer', 8000.00),
 * ('Praia', 'Viagens e Lazer', 1200.00),
 * ('Academia', 'Saúde e Bem-Estar', 800.00),
 * ('Terapia', 'Saúde e Bem-Estar', 1000.00),
 * ('Aniversário', 'Eventos', 2500.00),
 * ('Fundo Emergência', 'Reserva Financeira', 5000.00);
 */