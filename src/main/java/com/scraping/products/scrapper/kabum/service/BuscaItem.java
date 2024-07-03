package com.scraping.products.scrapper.kabum.service;

import com.microsoft.playwright.Page;
import com.scraping.products.exception.ValidacaoException;
import com.scraping.products.model.DadosConsulta;

public class BuscaItem implements ExecutaAcao{
    @Override
    public void executaAcao(Page page, DadosConsulta dados) {
        if(dados.getProdutoDesejado().isEmpty()){
            throw new ValidacaoException("Produto desejado nao informado");
        }
        page.waitForSelector("#input-busca").fill(dados.getProdutoDesejado());
        page.locator("#barraBuscaKabum > div > form > button").click();
    }
}
