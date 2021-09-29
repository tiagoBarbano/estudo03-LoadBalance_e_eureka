package com.api.cambio.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.api.cambio.model.CambioModel;
import com.api.cambio.repository.CambioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
    
    @Autowired
    private Environment environment;

    @Autowired
    private CambioRepository repository;

    @GetMapping(value = "/{valor}/{from}/{to}")
    public CambioModel getCambio(
                            @PathVariable("valor") BigDecimal valor,
                            @PathVariable("from") String from,
                            @PathVariable("to") String to){

        var cambio = repository.findByFromAndTo(from, to);

        if(cambio == null) throw new RuntimeException("Problema na conversão");
            var port = environment.getProperty("local.server.port");
            
            BigDecimal fatorConversao = cambio.getFatorConversao();
            BigDecimal valorConvetido = fatorConversao.multiply(valor);
            cambio.setValorConversao(valorConvetido.setScale(2, RoundingMode.CEILING));
            cambio.setEnviroment(port);         
    
        return cambio;
    }
}
