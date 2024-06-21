package com.ccdev.bookingmicroservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@NoArgsConstructor
@Setter
@Getter
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal price;
    private Integer quantity;
}
