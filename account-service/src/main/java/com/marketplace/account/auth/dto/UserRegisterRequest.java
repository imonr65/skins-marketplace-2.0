package com.marketplace.account.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterRequest(
        @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
        @NotBlank
        String name,
        @Size(min = 5, max = 255, message = "Адрес электронной почты должен содержать от 5 до 255 символов")
        @Email
        @NotBlank
        String email,
        @Size(min = 8, max = 100, message = "Длина пароля должна находится в диапазоне от 8 до 100 символов")
        @NotBlank
        String password
) {
}
