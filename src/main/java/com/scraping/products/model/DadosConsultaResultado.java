package com.scraping.products.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosConsultaResultado {
    @NotNull
    private String taskId;
    private String produtoDesejado;
    private JSONArray resultadoConsulta;

    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("taskId",this.taskId);
        json.put("produtoDesejado",this.produtoDesejado);
        json.put("resultado",this.resultadoConsulta);
        return json;
    }

}
