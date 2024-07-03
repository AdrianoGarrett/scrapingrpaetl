package com.scraping.products.model;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
@Getter
@Setter
public class Produto {
    private String descricaoProduto;
    private String valorProduto;
    private String valorProdutoAvista;
    private String urlProduto;

    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("descricaoProduto",this.descricaoProduto);
        json.put("valorProduto",this.valorProduto);
        json.put("valorProdutoAvista",this.valorProdutoAvista);
        json.put("urlProduto",this.urlProduto);
        if(this.valorProdutoAvista!=null&&this.valorProduto!=null){
            float valorProdutoFloat = Float.parseFloat(this.valorProduto.replace(".","").replace(",","."));
            float valorAvistaProdutoFloat = Float.parseFloat(this.valorProdutoAvista.replace(".","").replace(",","."));
            float desconto = (valorProdutoFloat - valorAvistaProdutoFloat);
            json.put("desconto",desconto);
        }
        return json;
    }

}
