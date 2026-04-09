package org.example.ex_02.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public String getAllOrders() {
        return "Danh sách đơn hàng";
    }

    public String getOrderById(Long id) {
        return "Thông tin đơn hàng với ID: " + id;
    }

    public String createOrder(String dishName) {
        return "Đã thêm đơn hàng mới cho món: " + dishName;
    }
}

