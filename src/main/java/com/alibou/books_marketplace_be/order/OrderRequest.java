package com.alibou.books_marketplace_be.order;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private Long buyerId;
    private Long paymentId;
    private Long shippingAddressId;
    private BigDecimal totalPrice;
}
