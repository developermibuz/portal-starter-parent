package com.example.sample.model.base;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sample.db.BaseEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataList<T> {
    private long total;
    private List<T> list;

    public static <T extends BaseEntity> DataList<T> from(Page<T> page) {
        return new DataList<>(
                page.getTotal(),
                page.getResult()
        );
    }
}
