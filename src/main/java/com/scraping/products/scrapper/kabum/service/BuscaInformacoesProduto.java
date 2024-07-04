package com.scraping.products.scrapper.kabum.service;

import com.microsoft.playwright.Page;
import com.scraping.products.exception.ValidacaoException;
import com.scraping.products.model.Produto;
import org.apache.commons.lang3.StringUtils;

public class BuscaInformacoesProduto {

    public void leInformacoes(Page page, Produto produto) {
        try{
            produto.setValor(getValorProdutoFromPageContent(page));
            produto.setValorAvista(getValorProdutoAvistaFromPageContent(page));
            setDescontoProduto(produto);
            produto.setCodigoKabum(getCodigoProdutoFromURL(page));
        } catch (Exception ex ){
            ex.printStackTrace(System.out);
        }

    }

    private void setDescontoProduto(Produto produto) {
        if(produto.getValor() > 0){
            produto.setDesconto (produto.getValor() - produto.getValorAvista());
        }
    }

    private Float getValorProdutoFromPageContent(Page page) {
        String valor = StringUtils.substringBetween(page.content(),"oldPrice\">R$&nbsp;","</span");
        if(valor == null){
            return 0.0f;
        }
        return Float.parseFloat(valor.replace(".","").replace(",","."));
    }

    private Float getValorProdutoAvistaFromPageContent(Page page) {
        String valor = StringUtils.substringBetween(page.content(),"finalPrice\">R$&nbsp;","</h4>");
        if(valor == null){
            return 0.0f;
        }
        return Float.parseFloat(valor.replace(".","").replace(",","."));
    }

    private int getCodigoProdutoFromURL(Page page) {
        try{
            return Integer.parseInt(StringUtils.substringBetween(page.url(),"produto/","/"));
        } catch (NumberFormatException ex){
            System.out.println(page.url());
            throw new ValidacaoException("Erro ao buscar codigo do produto");
        }
    }
}
