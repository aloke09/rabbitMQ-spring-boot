package com.bridgelabz.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Order
{
    private String orderId;
    private String orderName;
    private int qty;
    private double price;
}
