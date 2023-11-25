package br.com.diegogouveia;

import br.com.diegogouveia.Utils.CSVParser;
import br.com.diegogouveia.repository.PlanilhaVendasRepository;
import br.com.diegogouveia.repository.PlanilhaVendasRespositoryImpl;
import br.com.diegogouveia.service.PlanilhaVendasService;

public class Main {

    public static void main(String[] args){
        PlanilhaVendasRepository repository = new PlanilhaVendasRespositoryImpl();
        PlanilhaVendasService service = new PlanilhaVendasService(repository);

        service.criarTabela();
        service.insertRegistroVenda();
//        service.limparTabela();


        //
        CSVParser.parser().forEach(x-> System.out.println(x.toString()));
    }
}