package com.example.sample.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.mib.center.core.common.error.exception.AppMessageException;
import uz.mib.center.core.common.error.exception.AppNoDataFoundException;
import uz.mib.center.core.common.error.exception.AppParameterNotFoundException;
import uz.mib.center.core.common.error.exception.AppSystemException;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class TestController {

    @GetMapping
    public String hello(@RequestParam Map<String, String> param) {
        return LocaleContextHolder.getLocale().getLanguage();
    }

    @GetMapping("/test1")
    public String test1() {
        throw new AppMessageException("common.error.test-exception");
    }

    @GetMapping("/test2")
    public String test2() {
        throw new AppSystemException();
    }

    @GetMapping("/test3")
    public String test3() {
        throw new AppParameterNotFoundException("param1", "param2");
    }

    @GetMapping("/test4")
    public String test4() {
        throw new AppNoDataFoundException();
    }

    @Data
    public static class Query {
        private Integer page;
    }
}
