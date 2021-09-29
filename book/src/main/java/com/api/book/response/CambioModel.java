package com.api.book.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CambioModel implements Serializable {
    
    private Long id;
    private String from;
    private String to;
    private Double fatorConversao;
    private Double valorConversao;
    private String enviroment;
    
    public CambioModel(){}

    public CambioModel(Long id, String from, String to, 
                    Double fatorConversao, Double valorConversao, 
                    String enviroment){
        this.id = id;
        this.from = from;
        this.to = to;
        this.fatorConversao = fatorConversao;
        this.valorConversao = valorConversao;
        this.enviroment = enviroment;
    }
}
