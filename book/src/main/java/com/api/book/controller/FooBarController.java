//Exemplo de Retry, fallback, Circuit Breaker -> RateLimiter e Bulkhead
 
package com.api.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Foo Bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {
    
    private Logger Logger = LoggerFactory.getLogger(FooBarController.class);

    private long tempoInicial = System.currentTimeMillis();
 
    @Operation(summary = "FooBar")
    @GetMapping("/foo-bar")
    //@Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
    //@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    //@RateLimiter(name = "default")
    //@Bulkhead(name = "default")
    public String fooBar(){

        long elapsed = System.currentTimeMillis() - tempoInicial;

        Logger.info("Request para foo-bar está comprometida : " + elapsed);

       /* var response = new RestTemplate()
            .getForEntity("http://localhost:8080/foo-bar", String.class);
     */
        return "foo-bar!!!";    
        //return response.getBody();
    }

    public String fallbackMethod(Exception ex){

        Logger.info("Problema na requisição das chamada: " + ex);

        return "Problema na requisição das chamada";
    }
}
