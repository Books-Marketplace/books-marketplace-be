package com.alibou.books_marketplace_be.shippingaddress;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipping-addresses")
@RequiredArgsConstructor
public class ShippingAddressController {

    @PostMapping
    public ResponseEntity<ShippingAddressResponse> createShippingAddress(ShippingAddressRequest address) {
        return null;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ShippingAddressResponse>> getAddressesByUser(@PathVariable String userId) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingAddressResponse> updateShippingAddress(
            @PathVariable Long id,
            @RequestBody ShippingAddressRequest request
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingAddress(@PathVariable Long id) {
        return null;
    }
}