package com.api.cambio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "cambio")
@Getter
@Setter
public class CambioModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;

    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;

    @Column(name = "conversion_factor", nullable = false)
    private BigDecimal fatorConversao;

    @Transient
    private BigDecimal valorConversao;

    @Transient
    private String enviroment;

    public CambioModel(){}

    public CambioModel(Long id, String from, String to, 
                    BigDecimal fatorConversao, BigDecimal valorConversao, 
                    String enviroment){
        this.id = id;
        this.from = from;
        this.to = to;
        this.fatorConversao = fatorConversao;
        this.valorConversao = valorConversao;
        this.enviroment = enviroment;
    }
}
