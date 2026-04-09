package org.example.ex_05.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {

    private final Map<Long, String> database = new HashMap<>();
    private Long currentId = 1L;

    public String findById(Long id) {
        return database.getOrDefault(id, "Không tìm thấy đơn hàng");
    }

    public String save(String dishName) {
        database.put(currentId, dishName);
        return "Đã tạo đơn hàng " + currentId++ + " với món: " + dishName;
    }

    public String deleteById(Long id) {
        if (database.containsKey(id)) {
            database.remove(id);
            return "Đã xóa đơn hàng " + id;
        }
        return "Đơn hàng không tồn tại";
    }
}
