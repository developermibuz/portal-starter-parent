package com.example.sample.controller;

import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.mib.center.core.common.error.CustomEx;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping
public class TestController {

    @GetMapping
    public String hello(@RequestParam Map<String, String> param){
        throw new CustomEx();
    }

    @GetMapping("/error")
    public String error(@Valid Query query) throws BindException {
        throw new CustomEx();
    }

    @Data
    public static class Query{
        @Min(-1)
        @Max(100)
        @NotNull
        private Integer page;
    }
}
