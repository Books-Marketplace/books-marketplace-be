package com.alibou.books_marketplace_be.payment;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String cardNumber;
    private String cardHolderName;
    private String cvc;
    private Date expirationDate;
    private BigDecimal amount;
    private String userId;
    private Long orderId;
}
