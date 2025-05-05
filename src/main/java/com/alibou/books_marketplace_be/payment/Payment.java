package com.alibou.books_marketplace_be.payment;

import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.order.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "PAYMENTS")
public class Payment extends AbstractEntity {

    @NotNull
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @NotBlank
    private String cardNumber;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotBlank
    private String cvc;

    @NotNull
    private Date expirationDate;
}