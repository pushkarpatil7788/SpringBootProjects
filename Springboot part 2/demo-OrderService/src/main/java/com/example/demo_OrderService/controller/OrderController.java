package com.example.demo_OrderService.controller;

import com.example.demo_OrderService.model.Order;
import com.example.demo_OrderService.model.OrderResponseDto;
import com.example.demo_OrderService.model.ProductDto;
import com.example.demo_OrderService.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping("/placeorder")
    public Mono<ResponseEntity<OrderResponseDto>> placeorder(@RequestBody Order order) {
        System.out.println("Received order: " + order);

        return webClientBuilder.build().get()
                .uri("http://localhost:8081/products/" + order.getProductId())
                .retrieve()
                .bodyToMono(ProductDto.class)
                .map(productDTO -> {
                    OrderResponseDto responseDTO = new OrderResponseDto();

                    responseDTO.setOrderId(order.getId());
                    responseDTO.setProductId(order.getProductId());
                    responseDTO.setQuantity(order.getQuantity());

                    responseDTO.setProductName(productDTO.getName());
                    responseDTO.setProductPrice(productDTO.getPrice());
                    responseDTO.setTotalPrice(order.getQuantity() * productDTO.getPrice());

                    orderRepo.save(order);

                    return ResponseEntity.ok(responseDTO);
                })
                .onErrorResume(e -> {
                    e.printStackTrace();
                    return Mono.just(ResponseEntity.internalServerError().build());
                });
    }


    @GetMapping("")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }
}