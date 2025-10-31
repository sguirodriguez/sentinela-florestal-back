package com.sentinela.sentinela_florestal_back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private String message;
    private Long userId;

    public RegisterResponse(String message) {
        this.message = message;
    }
}
