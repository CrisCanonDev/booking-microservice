package com.ccdev.bookingmicroservice.Controller;

import com.ccdev.bookingmicroservice.Client.StockClient;
import com.ccdev.bookingmicroservice.Repository.OrderRepository;
import com.ccdev.bookingmicroservice.dto.OrderDto;
import com.ccdev.bookingmicroservice.entity.OrderEntity;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StockClient stockClient;

    @CircuitBreaker(name = "ProductStockCircuitBreaker", fallbackMethod = "fallbackToStockService")
    public String SaveOrder(@RequestBody OrderDto orderDto) {

        boolean inStock = orderDto.getOrderItems().stream().allMatch(orderItem -> stockClient.isStocked(orderItem.getCode()));

        if(inStock){
            OrderEntity order = new OrderEntity();
            order.setOrder(UUID.randomUUID().toString());
            order.setOrderItems(orderDto.getOrderItems());

            orderRepository.save(order);

            return"order saved";
        }

        return "order cannot be saved";
    }

    private String fallbackToStockService(){
        return "Something went wrong, please try again later";
    }
}
