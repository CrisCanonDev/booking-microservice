package com.ccdev.bookingmicroservice.Controller;

import com.ccdev.bookingmicroservice.Repository.OrderRepository;
import com.ccdev.bookingmicroservice.dto.OrderDto;
import com.ccdev.bookingmicroservice.entity.OrderEntity;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private OrderRepository orderRepository;

    public String SaveOrder(@RequestBody OrderDto orderDto) {
        OrderEntity order = new OrderEntity();
        order.setOrder(UUID.randomUUID().toString());
        order.setOrderItems(orderDto.getOrderItems());

        orderRepository.save(order);

        return"order saved";
}
}
