package com.scraping.products.model;

import jakarta.persistence.*;
import lombok.*;
import org.json.JSONObject;
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Produto")
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Float valor;
    private Float valorAvista;
    private String url;
    private Float desconto = 0.0f;

    @Column(name = "codigoKabum")
    private int codigoKabum;

    public JSONObject toJson(){
        JSONObject json = new JSONObject();

        json.put("descricaoProduto",this.descricao);
        json.put("valorProduto",this.valor);
        json.put("valorProdutoAvista",this.valorAvista);
        json.put("urlProduto",this.url);
        json.put("codigoKabum",this.codigoKabum);
        json.put("desconto", this.desconto);

        return json;
    }

}
