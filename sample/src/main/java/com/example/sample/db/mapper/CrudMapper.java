package com.example.sample.db.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import com.example.sample.db.BaseEntity;
import com.example.sample.db.BaseMapper;

import java.util.Locale;
import java.util.Map;

@SuppressWarnings("MybatisMapperMethodInspection")
public interface CrudMapper<T extends BaseEntity> extends BaseMapper {

    Long findByPage_COUNT(@Param("locale") Locale locale, Map<String, String> filter);

    Page<T> findByPage(@Param("locale") Locale locale, Map<String, String> filter);

    T findById(@Param("locale") Locale locale, @Param("id") long id);

    long insertEntity(T entity);

    long updateEntity(T entity);

    long deleteById(@Param("id") long id);
}
