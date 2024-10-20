package br.com.fiap.SpringBootContatos.repository;

import br.com.fiap.SpringBootContatos.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    // Buscar emails por destinatário
    List<Email> findByTo(String to);

    // Buscar emails por assunto
    List<Email> findBySubjectContaining(String subject);
}

