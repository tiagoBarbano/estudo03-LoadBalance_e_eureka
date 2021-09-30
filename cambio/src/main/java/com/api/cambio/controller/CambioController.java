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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cambio endPoint")
@RestController
@RequestMapping("cambio-service")
public class CambioController {
    
    @Autowired
    private Environment environment;

    @Autowired
    private CambioRepository repository;

    @Operation(summary = "Realizada conversão de valor entreduas moedas especificas")
    @GetMapping(value = "/{valor}/{from}/{to}")
    public CambioModel getCambio(
                            @PathVariable("valor") BigDecimal valor,
                            @PathVariable("from") String from,
                            @PathVariable("to") String to){

        CambioModel cambio = repository.findByFromAndTo(from, to);

        if(cambio == null) throw new RuntimeException("Problema na conversão");
            String port = environment.getProperty("local.server.port");
            
            BigDecimal fatorConversao = cambio.getFatorConversao();
            BigDecimal valorConvetido = fatorConversao.multiply(valor);
            cambio.setValorConversao(valorConvetido.setScale(2, RoundingMode.CEILING));
            cambio.setEnviroment(port);         
    
        return cambio;
    }
}
