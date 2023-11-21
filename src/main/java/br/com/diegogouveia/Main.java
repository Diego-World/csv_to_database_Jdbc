package br.com.diegogouveia;

import br.com.diegogouveia.Utils.CSVParser;
import br.com.diegogouveia.service.PlanilhaVendasService;

public class Main {

    public static void main(String[] args){
        PlanilhaVendasService service = new PlanilhaVendasService();

        service.criarTabela();
        service.insertRegistroVenda();
//        service.limparTabela();


        //
        CSVParser.parser().forEach(x-> System.out.println(x.toString()));
    }
}