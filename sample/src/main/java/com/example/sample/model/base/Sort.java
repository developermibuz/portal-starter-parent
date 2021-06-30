package com.example.sample.model.base;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Sort {

    @NotNull
    private SortOrder order;

    @NotBlank
    private String attr;
}