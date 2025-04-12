package com.alibou.books_marketplace_be.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User mapToUserEntity(UserRequestDto userRequest) {
        return User.builder()
                .email(userRequest.getEmail())
                .userName(userRequest.getUserName())
                .password(passwordEncoder.encode( userRequest.getPassword()))
                .build();

    }

    public UserResponseDto mapToUserResponseDto(User user) {
        return  UserResponseDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .build();
    }
}
