package br.com.fiap.SpringBootContatos.repository;

import br.com.fiap.SpringBootContatos.model.Contato;
import br.com.fiap.SpringBootContatos.model.PreferenciasUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreferenciasUsuarioRepository extends JpaRepository<PreferenciasUsuario, Long> {
    Optional<PreferenciasUsuario> findByUsuario(Contato usuario);
}

