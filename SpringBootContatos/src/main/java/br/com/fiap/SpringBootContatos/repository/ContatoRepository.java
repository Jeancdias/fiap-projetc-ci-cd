package br.com.fiap.SpringBootContatos.repository;

import br.com.fiap.SpringBootContatos.model.Contato;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    public Optional<Contato> findByNome(String nome);

    public Optional<Contato> findByEmail(String email);

    public List<Contato> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

}
