package br.com.fiap.SpringBootContatos.service;

import br.com.fiap.SpringBootContatos.dto.PreferenciasUsuarioDto;
import br.com.fiap.SpringBootContatos.model.Contato;
import br.com.fiap.SpringBootContatos.model.PreferenciasUsuario;
import br.com.fiap.SpringBootContatos.repository.ContatoRepository;
import br.com.fiap.SpringBootContatos.repository.PreferenciasUsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenciasUsuarioService {

    @Autowired
    private PreferenciasUsuarioRepository preferenciasUsuarioRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    public PreferenciasUsuarioDto gravarPreferencias(PreferenciasUsuarioDto preferenciasDto) {
        PreferenciasUsuario preferencias = new PreferenciasUsuario();
        Contato usuario = contatoRepository.findById(preferenciasDto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        preferencias.setUsuario(usuario);
        preferencias.setCorTema(preferenciasDto.corTema());
        preferencias.setNotificacoesEmail(preferenciasDto.notificacoesEmail());

        PreferenciasUsuario preferenciasSalvas = preferenciasUsuarioRepository.save(preferencias);

        return new PreferenciasUsuarioDto(
                preferenciasSalvas.getId(),
                preferenciasSalvas.getUsuario().getId(),
                preferenciasSalvas.getCorTema(),
                preferenciasSalvas.isNotificacoesEmail()
        );
    }

    public PreferenciasUsuarioDto buscarPreferenciasPorEmail(String email) {
        Contato usuario = contatoRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        PreferenciasUsuario preferencias = preferenciasUsuarioRepository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Preferências não encontradas para o e-mail: " + email));

        return new PreferenciasUsuarioDto(
                preferencias.getId(),
                preferencias.getUsuario().getId(),
                preferencias.getCorTema(),
                preferencias.isNotificacoesEmail()
        );
    }
}


