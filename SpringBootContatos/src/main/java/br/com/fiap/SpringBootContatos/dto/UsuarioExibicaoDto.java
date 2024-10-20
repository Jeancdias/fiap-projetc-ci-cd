package br.com.fiap.SpringBootContatos.dto;

import br.com.fiap.SpringBootContatos.model.Contato;

import java.time.LocalDate;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
        String sobrenome,
        String nomeUsuario,
        String email,
        LocalDate dataNascimento
) {

    public UsuarioExibicaoDto(Contato contato) {
        this(
                contato.getId(),
                contato.getNome(),
                contato.getSobrenome(),
                contato.getNomeUsuario(),
                contato.getEmail(),
                contato.getDataNascimento());
    }

}
