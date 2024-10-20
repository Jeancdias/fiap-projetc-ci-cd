package br.com.fiap.SpringBootContatos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/ola")
    public String ola(){
        return "Olá Mundo";
    }
}
