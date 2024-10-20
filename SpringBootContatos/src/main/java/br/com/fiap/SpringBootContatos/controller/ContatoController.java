package br.com.fiap.SpringBootContatos.controller;

import br.com.fiap.SpringBootContatos.dto.UsuarioCadastroDto;
import br.com.fiap.SpringBootContatos.dto.UsuarioExibicaoDto;
import br.com.fiap.SpringBootContatos.model.Contato;
import br.com.fiap.SpringBootContatos.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto gravar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        return service.gravar(usuarioCadastroDto);
    }

    @GetMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarTodosContatos() {
        return service.listarTodosContatos();
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @GetMapping("/usuario/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto listarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public Contato atualizar(@RequestBody Contato contato) {
        return service.atualizar(contato);
    }

    @GetMapping("/usuario/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Contato listarPorNome(@PathVariable String nome) {
        return service.buscarPorNome(nome);
    }

    @GetMapping("/usuario/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Contato listarPorEmail(@PathVariable String email) {
        return service.buscarPorEmail(email);
    }

    @GetMapping("/usuario/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarAniversariantes(@PathVariable LocalDate dataInicial, @PathVariable LocalDate dataFinal) {
        return service.exibirAniversáriantes(dataInicial, dataFinal);
    }


}
