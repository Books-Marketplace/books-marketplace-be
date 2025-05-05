package com.alibou.books_marketplace_be.cart;

import com.alibou.books_marketplace_be.book.Book;
import com.alibou.books_marketplace_be.common.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "CARTS")
public class Cart extends AbstractEntity {
    @NotNull
    @Positive
    private BigDecimal unitPrice;
    @NotBlank
    private String title;

    private int quantity;
    @NotNull
    @PositiveOrZero
    private BigDecimal totalPrice;
    @OneToMany(mappedBy = "cart")
    private List<Book> books;

}
