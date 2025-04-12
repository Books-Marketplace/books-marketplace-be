package com.alibou.books_marketplace_be.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank(message = "user name must not be empty")
    private String userName;
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email is not valid")
    private String email;
    @NotBlank(message = "Password must not be empty")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;
}
