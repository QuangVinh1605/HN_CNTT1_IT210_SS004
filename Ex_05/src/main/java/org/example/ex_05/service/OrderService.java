package org.example.ex_05.service;

import org.example.ex_05.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public String getOrderById(Long id) {
        return repository.findById(id);
    }

    public String createOrder(String dishName) {
        return repository.save(dishName);
    }

    public String deleteOrder(Long id) {
        return repository.deleteById(id);
    }
}
