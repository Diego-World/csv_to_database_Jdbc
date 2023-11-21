package br.com.diegogouveia.model;

import java.time.LocalDateTime;

public class PlanilhaVendas {
    private long idVenda;
    private LocalDateTime dataVenda;
    private long idProduto;
    private String produto;
    private double precoProduto;
    private long idFornecedor;
    private String fornecedor;
    private long idFabricante;
    private String fabricante;

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public long getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(long idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "PlanilhaVendas" +
                "idVenda=" + idVenda +
                ", dataVenda=" + dataVenda +
                ", idProduto=" + idProduto +
                ", produto='" + produto + '\'' +
                ", precoProduto=" + precoProduto +
                ", idFornecedor=" + idFornecedor +
                ", fornecedor='" + fornecedor + '\'' +
                ", idFabricante=" + idFabricante +
                ", fabricante='" + fabricante + '\'';
    }
}
