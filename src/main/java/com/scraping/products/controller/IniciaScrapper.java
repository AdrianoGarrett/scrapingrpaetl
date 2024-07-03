package com.scraping.products.controller;

import com.scraping.products.model.DadosConsulta;
import com.scraping.products.model.DadosConsultaResultado;
import com.scraping.products.model.TaskIdResult;
import com.scraping.products.scrapper.kabum.IniciaScrapperKabum;
import com.scraping.products.service.ResultadosConsulta;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/iniciascrapper")
public class IniciaScrapper {

    @Autowired
    ResultadosConsulta resultadosConsulta;

    @Autowired
    BeanFactory beanFactory;

    @PostMapping(value = "/kabum")
    public String iniciaScrapper(@RequestBody @Valid DadosConsulta dados){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        UUID uuid = UUID.randomUUID();

        IniciaScrapperKabum iniciaScrapperKabum = beanFactory.getBean(IniciaScrapperKabum.class);
        iniciaScrapperKabum.setDadosconsulta(dados);
        executorService.execute(iniciaScrapperKabum);
        dados.setTaskId(uuid.toString());

        System.out.println("Produto desejado: "+dados.getProdutoDesejado()+"\ntaskId:"+dados.getTaskId());

        return "{\"taskId\":\""+dados.getTaskId()+"\"}";
    }

    @PostMapping(value = "/getResultById")
    public String buscaResultado(@RequestBody @Valid TaskIdResult taskId){
        List<DadosConsultaResultado> dadosConsultaResultadoList = resultadosConsulta.getDadosConsultaResultadoList();
        DadosConsultaResultado dadosConsultaResultado = dadosConsultaResultadoList.stream().filter(f->f.getTaskId().equals(taskId.getTaskId())).findFirst().get();
        if(dadosConsultaResultadoList == null || dadosConsultaResultado == null){
            return "Nenhum valor encontrado para o taskId informado.";
        }
        return dadosConsultaResultado.toJson().toString();
    }


}
