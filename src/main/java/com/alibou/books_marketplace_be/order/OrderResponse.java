package com.alibou.books_marketplace_be.order;

import com.alibou.books_marketplace_be.payment.PaymentResponse;
import com.alibou.books_marketplace_be.shippingaddress.ShippingAddressResponse;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private LocalDateTime date;
    private BigDecimal totalPrice;
    private String orderNumber;
    private String orderStatus;
    private Long buyerId;
    private PaymentResponse payment;
    private ShippingAddressResponse shippingAddress;
}
