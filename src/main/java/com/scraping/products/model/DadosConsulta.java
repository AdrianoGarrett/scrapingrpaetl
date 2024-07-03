package com.scraping.products.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DadosConsulta {
    @NotNull
    private String produtoDesejado;
    private String taskId;
}
