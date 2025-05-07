package com.alibou.books_marketplace_be.order;

import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.payment.Payment;
import com.alibou.books_marketplace_be.shippingaddress.ShippingAddress;
import com.alibou.books_marketplace_be.user.UserInformation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "ORDERS")
public class Order extends AbstractEntity {
    private LocalDateTime date;
    private BigDecimal totalPrice;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private UserInformation buyer;
    private String orderNumber;
    private String orderStatus;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private ShippingAddress shippingAddress;
}
