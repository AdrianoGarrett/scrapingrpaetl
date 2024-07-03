package com.scraping.products.scrapper.kabum.service;

import com.microsoft.playwright.Page;
import com.scraping.products.model.Produto;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class RetornaListaDeProdutos {
    public List<Produto> buscaProdutos(Page page){
        List<Produto> produtos = new ArrayList<>();
        Document doc = Jsoup.parse(page.content());
        Elements produtosElements = doc.select("main[class]").select("article");

        produtosElements.forEach(produtoElement->{
            Produto produto = new Produto();
            produto.setUrlProduto("https://www.kabum.com.br/"+produtoElement.select("a[href]").attr("href"));
            produto.setDescricaoProduto(produtoElement.select("img[class=imageCard]").attr("title"));

            page.navigate(produto.getUrlProduto());

            page.waitForSelector("#logoKabum > a > img");

            new BuscaInformacoesProduto().leInformacoes(page,produto);

            produtos.add(produto);
        });

        return produtos;
    }
}
