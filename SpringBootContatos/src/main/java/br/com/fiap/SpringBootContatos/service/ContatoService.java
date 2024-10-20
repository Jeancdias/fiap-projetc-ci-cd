package br.com.fiap.SpringBootContatos.service;

import br.com.fiap.SpringBootContatos.dto.UsuarioCadastroDto;
import br.com.fiap.SpringBootContatos.dto.UsuarioExibicaoDto;
import br.com.fiap.SpringBootContatos.exception.UsuarioNaoEncontradoException;
import br.com.fiap.SpringBootContatos.model.Contato;
import br.com.fiap.SpringBootContatos.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public UsuarioExibicaoDto gravar(UsuarioCadastroDto usuarioCadastroDto){
        Contato contato = new Contato();
        BeanUtils.copyProperties(usuarioCadastroDto, contato);
        return new UsuarioExibicaoDto(contatoRepository.save(contato));
    }

    public UsuarioExibicaoDto buscarPorId(Long id){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if (contatoOptional.isPresent()){
            return new UsuarioExibicaoDto(contatoOptional.get());
        } else {
            throw  new UsuarioNaoEncontradoException("Usuario não encontrado");
        }

    }

    public List<Contato> listarTodosContatos(){
        return contatoRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if (contatoOptional.isPresent()){
            contatoRepository.delete(contatoOptional.get());
        } else {
            throw  new RuntimeException("Usuario não encontrado");
        }

    }

    public List<Contato> exibirAniversáriantes(LocalDate dataInicial, LocalDate dataFinal){
        return contatoRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }

    public Contato atualizar(Contato contato){
        Optional<Contato> contatoOptional = contatoRepository.findById(contato.getId());

        if (contatoOptional.isPresent()){
            return contatoRepository.save(contato);
        } else {
            throw  new RuntimeException("Usuario não encontrado.");
        }
    }

    public Contato buscarPorNome(String nome) {
        Optional<Contato> contatoOptional = contatoRepository.findByNome(nome);

        if (contatoOptional.isPresent()) {
            return contatoOptional.get();
        } else {
            throw new RuntimeException("Usuario não encontrado.");
        }
    }

    public Contato buscarPorEmail(String email) {
        Optional<Contato> contatoOptional = contatoRepository.findByEmail(email);

        if (contatoOptional.isPresent()) {
            return contatoOptional.get();
        } else {
            throw new RuntimeException("Usuario não encontrado.");
        }
    }

}
