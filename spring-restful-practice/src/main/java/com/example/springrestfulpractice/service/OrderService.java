package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.model.Meal;
import com.example.springrestfulpractice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> orderList;


    public OrderService() {

        List<Meal> meals1 = new ArrayList<>();
        meals1.add(new Meal("apple", 50, "it is gooood"));
        meals1.add(new Meal("banana", 30, "it is yellow"));

        List<Meal> meals2 = new ArrayList<>();
        meals2.add(new Meal("bird", 5000, "it is gooood"));
        meals2.add(new Meal("pig", 3500, "it is yellow"));


        this.orderList = new ArrayList<>();
        this.orderList.add(new Order(1, 80, "leo", meals1));
        this.orderList.add(new Order(2, 8500, "Ken", meals2));
    }

    public List<Order> getAllOrders() {
        return this.orderList;
    }

    public Order getOrderById(int seq) {
        for (Order order : this.orderList) {
            if (seq == order.getSeq()) {
                return order;
            }
        }
        return null;
    }


    public Order createOrder(Order order) {
        this.orderList.add(order);
        return order;
    }

    public Order updateOrder(int seq, Order order) {
        for (Order updatedOrder : this.orderList) {
            if (seq == updatedOrder.getSeq()) {
                updatedOrder.setTotalPrice(order.getTotalPrice());
                updatedOrder.setWaiter(order.getWaiter());
                updatedOrder.setMealList(order.getMealList());
                return updatedOrder;
            }
        }
        return null;
    }

    public Order deleteOrder(int seq) {
        for(Order deletedOrder:this.orderList){
            if(seq== deletedOrder.getSeq()){
                this.orderList.remove(deletedOrder);
                return deletedOrder;
            }
        }
        return null;    }

}
