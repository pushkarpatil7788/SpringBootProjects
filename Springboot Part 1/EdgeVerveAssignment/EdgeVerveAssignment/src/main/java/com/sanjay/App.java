package com.sanjay;

import com.sanjay.beans.LibraryService;
import com.sanjay.beans.OrderService;
import com.sanjay.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.setOrderId("qwf4-13fny");
        order.setOrderBy("Sanjay Jangid");
        order.setOrderItem("Dal Batti");
        System.out.println("OrderId: " + order.getOrderId());
        System.out.println("OrderBy: " + order.getOrderBy());
        System.out.println("Order Item: " + order.getOrderItem());
        System.out.println("Order's PaymentId: " + order.getPaymentService().getPaymentId());
        System.out.println("Order's Payment Amount: " + order.getPaymentService().getPaymentAmount());

        LibraryService library = context.getBean(LibraryService.class);
        library.setNoOfMembers(100);
        System.out.println("Books are: " + library.getAllBooksName());



    }
}
