package br.com.cloudnative.hexagonal.adapters.in.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record ClientRequest(
        @NotBlank String name,
        @CPF String cpf,
        @Email String email
) {
}
