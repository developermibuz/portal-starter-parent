package com.example.sample.controller;

import lombok.Data;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping
public class TestController {

    @GetMapping
    public String hello(@RequestParam Map<String, String> param) {
        return LocaleContextHolder.getLocale().getLanguage();
    }

    @Data
    public static class Query {
        @Min(-1)
        @Max(100)
        @NotNull
        private Integer page;
    }
}
