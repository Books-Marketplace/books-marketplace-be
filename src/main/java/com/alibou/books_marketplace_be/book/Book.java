package com.alibou.books_marketplace_be.book;

import com.alibou.books_marketplace_be.cart.Cart;
import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.user.UserInformation;
import jakarta.persistence.*;
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
    private String title;
    private String isbn;
    private String author;
    private BigDecimal price;
    private String description;
    private String image;
    @Enumerated(EnumType.STRING)
    private CategoryName category;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInformation admin;
    @ManyToMany(mappedBy = "whishlist")
    private List<UserInformation> whishlistedBy;
    private int numberOfRatings;
    private double averageRating;



}
