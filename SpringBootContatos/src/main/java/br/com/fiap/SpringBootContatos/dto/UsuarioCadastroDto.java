package br.com.fiap.SpringBootContatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UsuarioCadastroDto(
        Long id,

        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nome,

        @NotBlank(message = "O sobrenome do usuário é obrigatório!")
        String sobrenome,

        @NotBlank(message = "O nome de usuário é obrigatório!")
        String nomeUsuario,

        @NotBlank(message = "E-mail é obrigatório!")
        @Email(message = "O e-mail está com formato inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 6, max = 10, message = "A senha deve conter entre 6 e 10 caracteres.")
        String senha,

        @NotNull(message = "A data de nascimento é obritatória!")
        LocalDate dataNascimento
) {
}
