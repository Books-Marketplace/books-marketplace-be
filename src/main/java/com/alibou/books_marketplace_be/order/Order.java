package com.alibou.books_marketplace_be.order;

import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.payment.Payment;
import com.alibou.books_marketplace_be.shippingaddress.ShippingAddress;
import com.alibou.books_marketplace_be.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "ORDERS")
public class Order extends AbstractEntity {
    @NotNull
    private Date date;
    @NotNull
    @Positive
    private BigDecimal totalPrice;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User buyer;
    @NotBlank
    private String orderNumber;
    @NotBlank
    private String orderStatus;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private ShippingAddress shippingAddress;
}
