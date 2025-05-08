package com.alibou.books_marketplace_be.payment;

import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.order.Order;
import com.alibou.books_marketplace_be.user.UserInformation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "PAYMENTS")
public class Payment extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private String cardNumber;
    private String cardHolderName;

    private BigDecimal amount;
    private String cvc;
    private Date expirationDate;
    @ManyToOne
    private UserInformation userInformations;
}