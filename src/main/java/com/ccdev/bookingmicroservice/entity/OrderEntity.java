package com.ccdev.bookingmicroservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "order")
@NoArgsConstructor
@Setter
@Getter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String order;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems;
}
