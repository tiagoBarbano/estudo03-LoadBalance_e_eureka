package com.api.book.controller;

import com.api.book.model.BookModel;
import com.api.book.proxy.CambioProxy;
import com.api.book.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {
    
    @Autowired
    private Environment environment;
    
    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @GetMapping(value = "/{id}/{currency}")
    public BookModel findbook(
                    @PathVariable("id") Long id,
                    @PathVariable("currency") String currency){

        var book = repository.getById(id);

        if(book.getId() == null) throw new RuntimeException("Book não encontrado");
        
        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);
        
        var port = environment.getProperty("local.server.port");
        book.setEnviroment(port + " FEIGN");
        book.setPrice(cambio.getValorConversao());
        
        return book;
    }
}
                

/*    @GetMapping(value = "/{id}/{currency}")
    public BookModel findbook(
                    @PathVariable("id") Long id,
                    @PathVariable("currency") String currency){

        var book = repository.getById(id);

        if(book.getId() == null) throw new RuntimeException("Book não encontrado");
        
        HashMap<String, String> params = new HashMap<>();
        params.put("valor", Double.toString(book.getPrice()));
        params.put("from", "USD");
        params.put("to", currency);
            
        var response = new RestTemplate().getForEntity("http://localhost:8001/cambio-service/"
                           + "{valor}/{from}/{to}",
                         CambioModel.class, 
                         params);
        
        var cambio = response.getBody();

        var port = environment.getProperty("local.server.port");
        book.setEnviroment(port);
        book.setPrice(cambio.getValorConversao());
        
        return book;
    }*/
