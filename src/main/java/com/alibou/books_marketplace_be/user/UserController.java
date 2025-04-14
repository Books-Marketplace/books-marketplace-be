package com.alibou.books_marketplace_be.user;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> findAllUsers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        List<UserResponseDto> users = userService.findAllUsers(page, size);
        return ResponseEntity.ok(users);

    }

    @PutMapping("/{user-id}")
    public ResponseEntity<Void> updateUser(
            @Valid @PathVariable("user-id") long userId,
            @RequestBody UserRequestDto userRequestDto) {

        userService.updateUser(userId, userRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable("user-id") long userId) {

        UserResponseDto user = userService.findById(userId);
        return ResponseEntity.ok(user);

    }

    @PostMapping()
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {

        User user = userService.createUser(userRequestDto);
        return ResponseEntity.ok().build();
    }


}
