package org.example.ex_06.repository;

import org.example.ex_06.model.RestaurantTable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TableRepository {

    private final List<RestaurantTable> tables = new ArrayList<>();

    public TableRepository() {
        tables.add(new RestaurantTable(1L, 2, "Trống"));
        tables.add(new RestaurantTable(2L, 4, "Đang dùng"));
        tables.add(new RestaurantTable(3L, 6, "Trống"));
    }

    public List<RestaurantTable> findAll() {
        return tables;
    }

    public RestaurantTable findById(Long id) {
        return tables.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void delete(Long id) {
        tables.removeIf(t -> t.getId().equals(id));
    }
}
