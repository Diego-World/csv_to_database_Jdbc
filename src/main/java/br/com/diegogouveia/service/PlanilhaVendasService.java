package br.com.diegogouveia.service;

import br.com.diegogouveia.Utils.CSVParser;
import br.com.diegogouveia.config.DataBaseConfig;
import br.com.diegogouveia.repository.PlanilhaVendasRepository;
import br.com.diegogouveia.repository.PlanilhaVendasRespositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class PlanilhaVendasService {

    private final PlanilhaVendasRepository repository;

    public PlanilhaVendasService(PlanilhaVendasRepository repository) {
        this.repository = repository;
    }

    public void insertRegistroVenda() {
        Connection connection = getConnecetion();
        try {
            repository.inserirDados(connection, CSVParser.parser());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(connection);
        }
    }

    public void criarTabela() {
        Connection connection = getConnecetion();
        try {
            repository.criarTabela(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(connection);
        }
    }

    public void limparTabela() {
        Connection connection = getConnecetion();
        try {
            repository.apagarTodosDados(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(connection);
        }

    }

    private Connection getConnecetion() {

        Connection connection = null;
        try {
            connection = DataBaseConfig.getConnection();
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexão estabelecida com sucesso");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private void closeConnection(Connection connection) {
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