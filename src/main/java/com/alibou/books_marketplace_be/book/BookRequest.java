package com.alibou.books_marketplace_be.book;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private String description;
    private String image;
    private CategoryName category;
    private String adminId;

}
