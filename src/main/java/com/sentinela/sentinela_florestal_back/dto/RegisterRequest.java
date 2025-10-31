package com.sentinela.sentinela_florestal_back.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    
    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate birthday;
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;
    
    @NotBlank(message = "Senha é obrigatória")
    private String password;
    
    // Campos opcionais (endereço)
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private String zipcode;
    private String addressNumber;
    private String complement;
    
    // Campo opcional
    private Long cityHallId;
}

