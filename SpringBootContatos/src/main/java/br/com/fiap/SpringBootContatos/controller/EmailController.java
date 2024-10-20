package br.com.fiap.SpringBootContatos.controller;

import br.com.fiap.SpringBootContatos.dto.EmailDto;
import br.com.fiap.SpringBootContatos.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;
    private final ControleFrequenciaController controleFrequenciaService;

    @Autowired
    public EmailController(EmailService emailService, ControleFrequenciaController controleFrequenciaService) {
        this.emailService = emailService;
        this.controleFrequenciaService = controleFrequenciaService;
    }

    @PostMapping("/enviar")
    @ResponseStatus(HttpStatus.OK)
    public String enviarEmail(@Valid @RequestBody EmailDto emailDto) {
        String destinatario = emailDto.to();
        String mensagem = emailDto.body();

        // Verifica se o e-mail pode ser enviado (controle de frequência)
        if (!emailService.podeEnviarEmail(destinatario)) {
            return "Envio bloqueado: Aguarde o intervalo entre envios.";
        }

        // Verifica o conteúdo da mensagem (palavras proibidas)
        if (!emailService.isConteudoApropriado(mensagem)) {
            return "Envio bloqueado: O conteúdo do e-mail contém palavras proibidas.";
        }

        // Enviar o e-mail via serviço de envio
        emailService.sendEmail(emailDto);

        return "E-mail enviado com sucesso!";
    }
}
