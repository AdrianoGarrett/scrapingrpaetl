package com.scraping.products.scrapper.kabum.service.validacao;

import com.microsoft.playwright.Page;
import com.scraping.products.exception.ValidacaoException;
import com.scraping.products.model.DadosConsulta;
import com.scraping.products.scrapper.kabum.service.ExecutaAcao;

public class ValidaBusca implements ExecutaAcao {
    @Override
    public void executaAcao(Page page, DadosConsulta dados) {
        if(!page.url().toLowerCase().contains(dados.getProdutoDesejado().toLowerCase().replace(" ","-"))){
            throw new ValidacaoException("Erro ao buscar item desejado");
        }
    }
}
