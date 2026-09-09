package com.marketplace.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @Size(min = 5, max = 255, message = "Почта должна содержать от 5 до 255 символов")
        @NotBlank(message = "Почта пользователя не может быть пуста")
        String email,

        @Size(min = 8, max = 100, message = "Длина пароля должна содержать от 8 до 100 символов")
        @NotBlank
        String password
) {
}
