package com.alibou.books_marketplace_be.cart_line_temp;

import jakarta.persistence.*;

@Entity
public class CartLineTemp {
    @Id
    @GeneratedValue
    private long id;
    private String bookId;
    private String bookTitle;
    private String author;
    private int quantity;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private String userId;
    private boolean checked;


}
