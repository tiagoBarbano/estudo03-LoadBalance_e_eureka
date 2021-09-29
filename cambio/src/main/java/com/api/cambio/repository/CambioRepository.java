package com.api.cambio.repository;

import com.api.cambio.model.CambioModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<CambioModel, Long> {
    
    CambioModel findByFromAndTo(String from, String to);
}