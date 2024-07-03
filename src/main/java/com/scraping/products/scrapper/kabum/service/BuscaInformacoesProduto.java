package com.scraping.products.scrapper.kabum.service;

import com.microsoft.playwright.Page;
import com.scraping.products.model.Produto;
import org.apache.commons.lang3.StringUtils;

public class BuscaInformacoesProduto {

    public void leInformacoes(Page page, Produto produto) {
        try{
            produto.setValorProduto(StringUtils.substringBetween(page.content(),"oldPrice\">R$&nbsp;","</span"));
            produto.setValorProdutoAvista(StringUtils.substringBetween(page.content(),"finalPrice\">R$&nbsp;","</h4>"));
        } catch (Exception ex ){
            ex.printStackTrace(System.out);
        }

    }
}
