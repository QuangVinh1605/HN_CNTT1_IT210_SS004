package org.example.ex_04.controller;

import org.example.ex_04.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("legacyController")
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = {"/","/orders"})
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    @ResponseBody
    public String addOrder(@RequestParam String dishName) {
        return orderService.createOrder(dishName);
    }

    @GetMapping("/bai2/menu")
    @ResponseBody
    public String getMenu(@RequestParam(value = "category", required = false, defaultValue = "chay") String category) {
        return "Menu category: " + category;
    }

    @GetMapping("/bai3/orders/{id}")
    @ResponseBody
    public String getOrderDetail(@PathVariable Long id) {
        return "Chi tiết đơn hàng số " + id;
    }

    @GetMapping("/bai4/products")
    public String getProductList(@RequestParam String category,
                                  @RequestParam Integer limit,
                                  ModelMap modelMap) {
        modelMap.addAttribute("category", category).addAttribute("limit", limit).addAttribute("message", "Tìm kiếm thành công");
        return "productList";
    }
}

