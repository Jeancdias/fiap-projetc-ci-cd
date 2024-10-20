package br.com.fiap.SpringBootContatos.controller;

import br.com.fiap.SpringBootContatos.dto.EmailDto;
import br.com.fiap.SpringBootContatos.dto.EmailRequest;
import br.com.fiap.SpringBootContatos.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class ControleFrequenciaController {

    private final EmailService emailService;

    public ControleFrequenciaController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping("/enviar/tratrativa")
    @ResponseStatus(HttpStatus.OK)
    public String enviarEmail(@RequestBody EmailRequest emailRequest) {
        String destinatario = emailRequest.getDestinatario();
        String mensagem = emailRequest.getMensagem();

        // Verifica se o e-mail pode ser enviado com base na frequência
        if (!emailService.podeEnviarEmail(destinatario)) {
            return "Envio bloqueado: Aguarde o intervalo de 2 minutos entre envios.";
        }

        // Verifica se a mensagem contém palavras proibidas
        if (!emailService.isConteudoApropriado(mensagem)) {
            return "Envio bloqueado: O conteúdo do e-mail contém palavras proibidas.";
        }

        // Enviar o e-mail utilizando o serviço de e-mail
        emailService.sendEmail(new EmailDto(
                emailRequest.getDestinatario(),
                "emailDeOrigem@example.com", // Pode ser configurado conforme necessário
                emailRequest.getAssunto(),
                emailRequest.getMensagem()
        ));

        return "Email enviado com sucesso!";
    }
}
