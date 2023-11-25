package br.com.diegogouveia.service;

import br.com.diegogouveia.Utils.CSVParser;
import br.com.diegogouveia.config.DataBaseConfig;
import br.com.diegogouveia.repository.PlanilhaVendasRepository;
import br.com.diegogouveia.repository.PlanilhaVendasRespositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class PlanilhaVendasService {

    private final PlanilhaVendasRepository repository;
    public PlanilhaVendasService(PlanilhaVendasRepository repository){
        this.repository = repository;

    }
    public void insertRegistroVenda() {

        Connection connection = null;
        try {
            Connection conncetion = DataBaseConfig.getConnection();
            if (conncetion != null && !conncetion.isClosed()) {
                System.out.println("Conexão estabelecida com sucesso");
            }
            repository.inserirDados(conncetion, CSVParser.parser());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {


                if (connection != null && !connection.isClosed()  ) {
                    connection.close();
                    System.out.println("Conexão fechada com sucesso");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public void criarTabela() {

        Connection connection = null;
        try {
            Connection conncetion = DataBaseConfig.getConnection();
            if (conncetion != null && !conncetion.isClosed()) {
                System.out.println("Conexão estabelecida com sucesso");
            }
            repository.criarTabela(conncetion);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Conexão fechada com sucesso");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public void limparTabela() {
        PlanilhaVendasRespositoryImpl repository = new PlanilhaVendasRespositoryImpl();
        Connection connection = null;
        try {
            Connection conncetion = DataBaseConfig.getConnection();
            if (conncetion != null && !conncetion.isClosed()) {
                System.out.println("Conexão estabelecida com sucesso");
            }
            repository.apagarTodosDados(conncetion);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Conexão fechada com sucesso");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }

    }
}