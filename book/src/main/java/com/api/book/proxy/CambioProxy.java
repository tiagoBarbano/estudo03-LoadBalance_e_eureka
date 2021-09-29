package com.api.book.proxy;

import com.api.book.response.CambioModel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cambio-service")
public interface CambioProxy {

    @GetMapping(value = "/cambio-service/{valor}/{from}/{to}")
    public CambioModel getCambio(
                            @PathVariable("valor") Double valor,
                            @PathVariable("from") String from,
                            @PathVariable("to") String to);
}
