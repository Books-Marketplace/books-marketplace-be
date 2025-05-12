package com.alibou.books_marketplace_be.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    @GetMapping("/{userId}")
    public ResponseEntity<CartResponse> getCartByUser(@PathVariable String userId) {
        return null;
    }

    @PostMapping("/add/{userId}/{bookId}")
    public ResponseEntity<CartResponse> addBookToCart(
            @PathVariable String userId,
            @PathVariable Long bookId
    ) {
        return null;
    }

    @DeleteMapping("/remove/{userId}/{bookId}")
    public ResponseEntity<CartResponse> removeBookFromCart(
            @PathVariable String userId,
            @PathVariable Long bookId
    ) {
        return null;
    }
}
