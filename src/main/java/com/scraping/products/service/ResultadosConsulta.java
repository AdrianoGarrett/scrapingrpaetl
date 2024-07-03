package com.scraping.products.service;

import com.scraping.products.model.DadosConsulta;
import com.scraping.products.model.DadosConsultaResultado;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
public class ResultadosConsulta {
    private List<DadosConsultaResultado> dadosConsultaResultadoList = new ArrayList<>();

    public void adicionaNaLista(DadosConsultaResultado dados){
         dadosConsultaResultadoList.add(dados);
    }

}
