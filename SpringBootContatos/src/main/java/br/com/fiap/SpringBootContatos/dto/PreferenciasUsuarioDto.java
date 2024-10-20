package br.com.fiap.SpringBootContatos.dto;

import br.com.fiap.SpringBootContatos.model.PreferenciasUsuario;

public record PreferenciasUsuarioDto(
        Long id,
        Long usuarioId,
        String corTema,
        boolean notificacoesEmail
) {

}

