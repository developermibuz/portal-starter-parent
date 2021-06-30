package com.example.sample.db.entities.crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sample.db.BaseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity implements BaseEntity {

    private Long id;
    private String name_ru;
    private String name_uk;
    private String name_uz;
    private Integer ordering;

    //--
    private String name;
}
