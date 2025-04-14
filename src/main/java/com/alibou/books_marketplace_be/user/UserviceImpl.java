package com.alibou.books_marketplace_be.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserviceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(UserRequestDto userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("User with this email already exists");
        }
        User user = userMapper.mapToUserEntity(userRequest);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<UserResponseDto> findAllUsers(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAll(pageRequest)
                .getContent()
                .stream()
                .map(userMapper::mapToUserResponseDto)
                .toList();
    }

    @Override
    public void updateUser(Long userId, UserRequestDto userRequest) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
        user.setUserName(userRequest.getUserName());
    }

    @Override
    public UserResponseDto findById(Long userId) {
       return userRepository.findById(userId)
               .map(userMapper::mapToUserResponseDto)
               .orElseThrow(()-> new RuntimeException("user not found"));
    }
}
