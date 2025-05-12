package com.alibou.books_marketplace_be.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserInformationController {

    @PostMapping
    public ResponseEntity<UserInformationResponse> createUser(UserInformationRequest user) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<UserInformationResponse>> getAllUsers() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInformationResponse> getUserById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserInformationResponse> updateUser(@PathVariable Long id,UserInformationRequest user) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return null;
    }
}
