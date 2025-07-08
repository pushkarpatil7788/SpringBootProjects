package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.Order;
import java.util.List;

public interface OrderServiceInterface {
    void addOrder(Order order);
    void saveOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(int orderId);
    void updateOrder(int orderId, Order updatedOrder);
    void deleteOrder(int orderId);
}
