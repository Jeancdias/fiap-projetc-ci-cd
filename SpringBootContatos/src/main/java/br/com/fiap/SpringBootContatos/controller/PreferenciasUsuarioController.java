package br.com.fiap.SpringBootContatos.controller;

import br.com.fiap.SpringBootContatos.dto.PreferenciasUsuarioDto;
import br.com.fiap.SpringBootContatos.service.PreferenciasUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferencias")
public class PreferenciasUsuarioController {

    @Autowired
    private PreferenciasUsuarioService preferenciasUsuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PreferenciasUsuarioDto gravarPreferencias(@RequestBody PreferenciasUsuarioDto preferenciasDto) {
        return preferenciasUsuarioService.gravarPreferencias(preferenciasDto);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public PreferenciasUsuarioDto buscarPreferenciasPorEmail(@PathVariable String email) {
        return preferenciasUsuarioService.buscarPreferenciasPorEmail(email);
    }
}

