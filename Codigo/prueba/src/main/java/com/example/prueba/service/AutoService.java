package com.example.prueba.service;

import com.example.prueba.entity.Auto;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 * Contrato para los servicios
 */
public interface AutoService {

    public ResponseEntity<?> findAll();

    public ResponseEntity<?> findById(Long id);
    
    public ResponseEntity<?> save(Auto auto, BindingResult body );
    
    public ResponseEntity<?> update(Auto auto, BindingResult body , Long id);
    
    public ResponseEntity<?> delete(Long id);

}
