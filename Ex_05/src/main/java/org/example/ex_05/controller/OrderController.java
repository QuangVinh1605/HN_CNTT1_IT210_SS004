package org.example.ex_05.controller;

import org.example.ex_05.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bai5/orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public String createOrder(@RequestParam String dishName) {
        return service.createOrder(dishName);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return service.deleteOrder(id);
    }
}
