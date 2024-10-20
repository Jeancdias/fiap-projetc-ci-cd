package br.com.fiap.SpringBootContatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmailDto(

        @NotBlank(message = "O e-mail do destinatário é obrigatório!")
        @Email(message = "O e-mail está com formato inválido")
        String to,

        @NotBlank(message = "O e-mail do remetente é obrigatório!")
        @Email(message = "O e-mail está com formato inválido")
        String from,

        @NotBlank(message = "O assunto é obrigatório!")
        @Size(min = 1, max = 35, message = "O assunto deve conter entre 1 e 35 caracteres.")
        String subject,

        @NotBlank(message = "A mensagem é obrigatória!")
        String body
) {
}
