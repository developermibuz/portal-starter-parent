package com.example.sample.model.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
public class PageQuery {
    @Min(-1)
    @NotNull
    private Integer pageNo;

    @Min(-1)
    @Max(100)
    @NotNull
    private Integer pageSize;

    @Valid
    private Sort sort;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public String getOrderBy() {
        if (sort == null) return null;
        return String.format("a.%s %s", sort.getAttr(), sort.getOrder());
    }

}
