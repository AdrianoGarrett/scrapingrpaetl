package com.scraping.products.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskIdResult {
    @NotNull
    private String taskId;
}
