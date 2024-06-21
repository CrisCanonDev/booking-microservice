package com.ccdev.bookingmicroservice.dto;

import com.ccdev.bookingmicroservice.entity.OrderEntity;
import com.ccdev.bookingmicroservice.entity.OrderItemEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private List<OrderItemEntity> orderItems;
}
