package com.example.sample.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import com.example.sample.db.BaseEntity;
import com.example.sample.db.mapper.CrudMapper;
import com.example.sample.model.base.DataList;
import com.example.sample.model.base.PageQuery;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
//@Api(tags = "All CRUDs")
@RequiredArgsConstructor
public abstract class AbstractCrudController<T extends BaseEntity, C extends CrudMapper<T>> {

    protected final C mapper;

    @GetMapping("/{id}")
    protected T getOne(@PathVariable("id") Long id) {
        val locale = LocaleContextHolder.getLocale();
        return mapper.findById(locale, id);
    }

    @GetMapping
    protected DataList<T> getPaging(@RequestParam Map<String, String> filter, @Valid PageQuery query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize(), query.getOrderBy());
        Page<T> page = mapper.findByPage(LocaleContextHolder.getLocale(), filter);
        return DataList.from(page);
    }

    @GetMapping("/all")
    protected List<T> getAll(@RequestParam Map<String, String> filter) {
        return mapper.findByPage(LocaleContextHolder.getLocale(), filter);
    }

    @PostMapping
    protected Long create(@RequestBody T entity) {
        return mapper.insertEntity(entity);
    }

    @PutMapping
    protected Long update(@RequestBody T entity) {
        return mapper.updateEntity(entity);
    }

    @DeleteMapping("/{id}")
    protected Long delete(@PathVariable("id") Long id) {
        return mapper.deleteById(id);
    }
}
