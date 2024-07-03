package com.scraping.products.scrapper.kabum;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.scraping.products.model.DadosConsulta;
import com.scraping.products.model.DadosConsultaResultado;
import com.scraping.products.model.Produto;
import com.scraping.products.scrapper.kabum.service.BuscaItem;
import com.scraping.products.scrapper.kabum.service.RetornaListaDeProdutos;
import com.scraping.products.scrapper.kabum.service.validacao.ValidaBusca;
import com.scraping.products.service.ResultadosConsulta;
import lombok.Setter;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Component
@Scope(value="prototype")
public class IniciaScrapperKabum implements Runnable{

    DadosConsulta dadosconsulta;

    @Autowired
    ResultadosConsulta resultadosConsulta;

    @Override
    public void run() {
        iniciaConsulta();
    }

    public IniciaScrapperKabum(DadosConsulta dadosconsulta){
        this.dadosconsulta = dadosconsulta;
    }

    private void iniciaConsulta() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.kabum.com.br/");

            new BuscaItem().executaAcao(page,dadosconsulta);
            new ValidaBusca().executaAcao(page,dadosconsulta);

            List<Produto> produtos = new RetornaListaDeProdutos().buscaProdutos(page);
            JSONArray jsonArray = new JSONArray();

            produtos.forEach(produto->{
                System.out.println(produto.toJson().toString());
                jsonArray.put(produto.toJson());
            });
            System.out.println(jsonArray);

            DadosConsultaResultado dadosConsultaResultado = new DadosConsultaResultado();

            dadosConsultaResultado.setTaskId(dadosconsulta.getTaskId());
            dadosConsultaResultado.setProdutoDesejado(dadosconsulta.getProdutoDesejado());
            dadosConsultaResultado.setResultadoConsulta(jsonArray);

            resultadosConsulta.adicionaNaLista(dadosConsultaResultado);

            browser.close();
        } catch (Exception ex){
            ex.printStackTrace(System.out);
        }

    }
}
