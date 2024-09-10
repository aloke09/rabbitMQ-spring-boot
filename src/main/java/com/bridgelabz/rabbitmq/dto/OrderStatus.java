package com.bridgelabz.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderStatus
{
    private Order order;
    private String status;//pending or completed
    private String message;
}
