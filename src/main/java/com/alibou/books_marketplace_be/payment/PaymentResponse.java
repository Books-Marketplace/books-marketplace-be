package com.alibou.books_marketplace_be.payment;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    private Long id;
    private BigDecimal amount;
    private String userId;
    private Long orderId;
    private String status;
}
