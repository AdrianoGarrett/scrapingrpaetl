package com.scraping.products.scrapper.kabum.service;

import com.microsoft.playwright.Page;
import com.scraping.products.model.DadosConsulta;

public interface ExecutaAcao {
    void executaAcao(Page page, DadosConsulta dados);
}
