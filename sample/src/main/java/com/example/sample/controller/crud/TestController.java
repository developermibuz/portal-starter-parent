package com.example.sample.controller.crud;

import com.example.sample.controller.AbstractCrudController;
import com.example.sample.db.entities.crud.TestEntity;
import com.example.sample.db.mapper.crud.TestMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController extends AbstractCrudController<TestEntity, TestMapper> {

    public TestController(TestMapper mapper) {
        super(mapper);
    }


}
