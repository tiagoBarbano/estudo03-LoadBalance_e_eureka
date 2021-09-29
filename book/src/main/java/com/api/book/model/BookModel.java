package com.api.book.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Getter
@Setter
public class BookModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", nullable = false, length = 180)
    private String author;

    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "title", nullable = false, length = 180)
    private String title;

    @Transient
    private String currenty;
    
    @Transient
    private String enviroment;

    public BookModel() {}

    public BookModel(Long id,String author,String title,
                    Date launchDate,double price,String currenty,
                    String enviroment){
        
        this.id = id;
        this.author = author;
        this.title = title;
        this.launchDate = launchDate;
        this.price = price;
        this.currenty = currenty;
        this.enviroment = enviroment;
    }
}
