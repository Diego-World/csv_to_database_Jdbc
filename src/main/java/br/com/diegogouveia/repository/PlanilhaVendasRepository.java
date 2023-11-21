package br.com.diegogouveia.repository;

import br.com.diegogouveia.model.PlanilhaVendas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PlanilhaVendasRepository {
    void criarTabela(Connection connection) throws SQLException;

    void inserirDados(Connection connection, List<PlanilhaVendas> vendasList) throws SQLException;
    void apagarTodosDados(Connection connection) throws SQLException;


}
