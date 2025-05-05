package com.alibou.books_marketplace_be.book;

import com.alibou.books_marketplace_be.cart.Cart;
import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.rate.Rate;
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
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "BOOKS")
public class Book extends AbstractEntity {
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotNull
    @Positive
    private BigDecimal price;
    private String description;
    private String image;
    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryName category;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @OneToMany(mappedBy = "book")
    private List<Rate> ratings;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User admin;
    @ManyToMany(mappedBy = "favoriteBooks")
    private List<User> favoritedBy;


}
