package com.alibou.books_marketplace_be.cart_line_temp;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartLineresponse {
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
