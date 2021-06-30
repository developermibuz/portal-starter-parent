package com.example.sample.db.mapper.crud;

import org.apache.ibatis.annotations.Mapper;
import com.example.sample.db.entities.crud.TestEntity;
import com.example.sample.db.mapper.CrudMapper;

@Mapper
public interface TestMapper extends CrudMapper<TestEntity> {
}
