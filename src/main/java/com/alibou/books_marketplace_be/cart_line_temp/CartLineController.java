package com.alibou.books_marketplace_be.cart_line_temp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/temp-orders")
@RequiredArgsConstructor
public class CartLineController {

    @PostMapping
    public ResponseEntity<CartLineresponse> addBookToTempOrder(CartLineresponse cartLine) {
        return null;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartLineresponse>> getTempOrdersByUser(@PathVariable String userId) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartLineresponse> updateTempOrder(@PathVariable long id, CartLineresponse cartLine) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTempOrder(@PathVariable long id) {
        return null;
    }
}
