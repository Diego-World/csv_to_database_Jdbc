package br.com.diegogouveia.Utils;

import br.com.diegogouveia.model.PlanilhaVendas;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    private static final String CAMINHO_ARQUIVO = "src/main/resources/vendas.csv";

    public static List<PlanilhaVendas> parser() {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(CAMINHO_ARQUIVO)).withSkipLines(1).build()) {
            List<String[]> linhas = reader.readAll();
            return mapearParaObjetos(linhas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<PlanilhaVendas> mapearParaObjetos (List < String[]>linhas){
        List<PlanilhaVendas> vendasList = new ArrayList<>();

        for (String[] linha : linhas) {
            PlanilhaVendas venda = new PlanilhaVendas();
            venda.setIdVenda(Long.parseLong(linha[0]));
            venda.setDataVenda(LocalDateTime.parse(linha[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            venda.setIdProduto(Long.parseLong(linha[2]));
            venda.setProduto(linha[3]);
            venda.setPrecoProduto(Double.parseDouble(linha[4]));
            venda.setIdFornecedor(Long.parseLong(linha[5]));
            venda.setFornecedor(linha[6]);
            venda.setIdFabricante(Long.parseLong(linha[7]));
            venda.setFabricante(linha[8]);

            vendasList.add(venda);
            }
        return vendasList; // Lista de objetos
    }
}