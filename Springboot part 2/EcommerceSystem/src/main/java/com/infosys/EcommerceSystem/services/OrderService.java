package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.Order;
import com.infosys.EcommerceSystem.repos.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceInterface {

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void addOrder(Order order) {
        orderRepo.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }

    @Override
    public void updateOrder(int orderId, Order updatedOrder) {
        Order existing = orderRepo.findById(orderId).orElse(null);
        if (existing != null) {
            existing.setOrderDate(updatedOrder.getOrderDate());
            existing.setProducts(updatedOrder.getProducts());
            existing.setUser(updatedOrder.getUser());
            orderRepo.save(existing);
        }
    }

    @Transactional
    public void deleteOrder(int orderId) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();

            order.getProducts().clear();
            orderRepo.save(order);

            orderRepo.delete(order);
            System.out.println("Order deleted successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }


    @Override
    public void saveOrder(Order order) {
        orderRepo.save(order);
    }
}
