package com.example.springrestfulpractice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springrestfulpractice.model.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {
        List<Order> orderedList = this.orderService.getAllOrders();
        return orderedList;
    }

    @GetMapping("/{seq}")
    public Order getOrderById(@PathVariable int seq) {
        Order order=this.orderService.getOrderById(seq);
        return order;
    }

    @PostMapping()
    public Order createOrder(@RequestBody Order order){
        Order createdUser=this.orderService.createOrder(order);
        return createdUser;
    }

    @PutMapping("/{seq}")
    public Order updateOrder(@PathVariable int seq,@RequestBody Order order){
        Order updatedOrder=this.orderService.updateOrder(seq,order);
        return updatedOrder;
    }

    @DeleteMapping("/{seq}")
    public Order deleteOrder(@PathVariable int seq){
        Order deletedOrder=this.orderService.deleteOrder(seq);
        return deletedOrder;
    }


}
