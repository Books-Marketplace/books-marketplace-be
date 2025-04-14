package com.alibou.books_marketplace_be.user;

import java.util.List;

public interface UserService {
    User createUser(UserRequestDto user);
    void updateUser(Long userId, UserRequestDto user);
    List<UserResponseDto> findAllUsers(int page, int size);
    UserResponseDto findById(Long userId);
}
