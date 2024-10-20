package br.com.fiap.SpringBootContatos.service;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FiltroConteudoService {

    private final List<String> palavrasBloqueadas = Arrays.asList("spam", "oferta", "promoção", "grátis");


    //Metodo para verificar se o conteúdo contém palavras proibidas
    public boolean contemPalavrasBloqueadas(String mensagem) {
        for (String palavra : palavrasBloqueadas) {
            if (mensagem.toLowerCase().contains(palavra)) {
                return true;
            }
        }
        return false;
    }
}

