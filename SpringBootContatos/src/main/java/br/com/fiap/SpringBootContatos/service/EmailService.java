package br.com.fiap.SpringBootContatos.service;

import br.com.fiap.SpringBootContatos.dto.EmailDto;
import br.com.fiap.SpringBootContatos.model.Email;
import br.com.fiap.SpringBootContatos.repository.EmailRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;
    private final FiltroConteudoService filtroConteudoService;
    private final List<String> palavrasProibidas = Arrays.asList("spam", "fraude", "promoção");
    private final Map<String, Long> historicoEnvio = new HashMap<>();

    // Construtor para injeção de dependências

    public EmailService(JavaMailSender mailSender, EmailRepository emailRepository, FiltroConteudoService filtroConteudoService) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
        this.filtroConteudoService = filtroConteudoService;
    }

    // Verifica se o e-mail pode ser enviado baseado na frequência de envio
    public boolean podeEnviarEmail(String destinatario) {
        long tempoAtual = System.currentTimeMillis();
        long tempoMinimoEntreEnvios = 2 * 60 * 1000; // 2 minutos

        Long ultimoEnvio = historicoEnvio.get(destinatario);
        if (ultimoEnvio == null || (tempoAtual - ultimoEnvio) >= tempoMinimoEntreEnvios) {
            historicoEnvio.put(destinatario, tempoAtual);
            return true;
        }
        return false;
    }

    // Verifica se o conteúdo tem palavras proibidas
    public boolean isConteudoApropriado(String mensagem) {
        return palavrasProibidas.stream().noneMatch(mensagem.toLowerCase()::contains);
    }

    // Metodo para envio de e-mail
    public void sendEmail(EmailDto emailDto) {
        // Criando um objeto de Email para enviar e persistir
        Email email = new Email();
        email.setTo(emailDto.to());
        email.setFrom(emailDto.from());
        email.setSubject(emailDto.subject());
        email.setBody(emailDto.body());
        email.setSentAt(LocalDateTime.now());

        // Envio do e-mail utilizando JavaMailSender
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        mailSender.send(message);

        // Salvando no banco de dados
        emailRepository.save(email);
    }
}
