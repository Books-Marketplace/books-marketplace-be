package com.alibou.books_marketplace_be.book;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private BigDecimal price;
    private String description;
    private String image;
    private CategoryName category;
    private String adminId;
    private int numberOfRatings;
    private double averageRating;
}
