package org.example.ex_06.service;

import org.example.ex_06.model.RestaurantTable;
import org.example.ex_06.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {

    private final TableRepository repo;

    @Autowired
    public TableService(TableRepository repo) {
        this.repo = repo;
    }

    public List<RestaurantTable> filterByCapacity(int cap) {
        return repo.findAll().stream()
                .filter(t -> t.getCapacity() >= cap)
                .collect(Collectors.toList());
    }

    public RestaurantTable getById(Long id) {
        return repo.findById(id);
    }

    public void updateStatus(Long id, String status) {
        RestaurantTable table = repo.findById(id);
        if (table != null) {
            table.setStatus(status);
        }
    }

    public String delete(Long id) {
        RestaurantTable table = repo.findById(id);
        if (table == null) return "Không tồn tại";

        if (table.getStatus().equals("Đang dùng")) {
            return "Không thể xóa bàn đang có khách!";
        }

        repo.delete(id);
        return "Đã xóa bàn";
    }
}
