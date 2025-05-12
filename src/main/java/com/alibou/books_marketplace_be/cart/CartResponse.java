package com.alibou.books_marketplace_be.cart;

import com.alibou.books_marketplace_be.book.BookResponse;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponse {
    private Long id;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal totalPrice;
    private List<BookResponse> books;
}
