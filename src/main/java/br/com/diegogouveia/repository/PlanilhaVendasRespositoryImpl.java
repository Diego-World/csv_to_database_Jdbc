package br.com.diegogouveia.repository;

import br.com.diegogouveia.model.PlanilhaVendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PlanilhaVendasRespositoryImpl implements PlanilhaVendasRepository {

    @Override
    public void criarTabela(Connection connection){
        String sql = "CREATE TABLE IF NOT EXISTS planilha_vendas (" +
                "id_venda BIGINT PRIMARY KEY," +
                "data_venda DATETIME," +
                "id_produto BIGINT," +
                "produto VARCHAR(255)," +
                "preco_produto DOUBLE," +
                "id_fornecedor BIGINT," +
                "fornecedor VARCHAR(255)," +
                "id_fabricante BIGINT," +
                "fabricante VARCHAR(255))";

                try(PreparedStatement statement = connection.prepareStatement(sql)){
                    statement.execute();
                }catch (SQLException e){
                    System.out.println("Tabela não foi criada");
                    System.out.println(e.getMessage());
                }
    }

    @Override
    public void inserirDados(Connection connection, List<PlanilhaVendas> vendasList){
        String sql = "INSERT INTO planilha_vendas (id_venda, data_venda, id_produto, produto, preco_produto, id_fornecedor, fornecedor, id_fabricante, fabricante) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (PlanilhaVendas venda : vendasList) {
                statement.setLong(1, venda.getIdVenda());
                statement.setObject(2, venda.getDataVenda());
                statement.setLong(3, venda.getIdProduto());
                statement.setString(4, venda.getProduto());
                statement.setDouble(5, venda.getPrecoProduto());
                statement.setLong(6, venda.getIdFornecedor());
                statement.setString(7, venda.getFornecedor());
                statement.setLong(8, venda.getIdFabricante());
                statement.setString(9, venda.getFabricante());

                statement.executeUpdate();
            }
        }catch (SQLException e){
            System.out.println("Insert não realizado");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void apagarTodosDados(Connection connection){
        String sql = "DELETE FROM planilha_vendas";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("'Delete ALL' Não realizado");
            System.out.println(e.getMessage());
        }
    }

}