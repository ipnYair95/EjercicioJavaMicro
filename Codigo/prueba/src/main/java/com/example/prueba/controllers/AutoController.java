package com.example.prueba.controllers;

import com.example.prueba.entity.Auto;
import com.example.prueba.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

/**
 * Clase REST para autos
 */
@RestController
@CrossOrigin(   origins = "*",  allowedHeaders = "*" ) 
public class AutoController {

    //Inyeccion de dependencia
    @Autowired
    private AutoService autoService;

    /**
     * Listar autos
     * @return autos | algun error que haya ocurrido
     */
    @GetMapping("/auto")
    public ResponseEntity<?> listar(){
    	ResponseEntity<?> resp = autoService.findAll();
    	return resp;
    }

    /**
     * Buscar un auto por id
     * @param id del auto
     * @return  autos | algun error que haya ocurrido
     */
    @GetMapping("/auto/{id}")
    public ResponseEntity<?> getAuto(@PathVariable  Long id){
    	ResponseEntity<?> resp = autoService.findById(id);
    	return resp;
    }

    /**
     * Eliminar un auto por id
     * @param id del auto
     * @return  String de exito | algun error que haya ocurrido
     */
    @DeleteMapping("/auto/{id}")
    public ResponseEntity<?> deleteAuto(@PathVariable Long id){
    	ResponseEntity<?> resp = autoService.delete(id);
    	return resp;
    }

    /**
     * Editar un auto
     * @param auto Instancia de objeto para actualizar
     * @param body Validación de la instancia sobre sus campos
     * @param id del auto
     * @return  String de exito | algun error que haya ocurrido
     */
    @PutMapping("/auto/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Auto auto, BindingResult body, @PathVariable Long id ){
    	ResponseEntity<?> resp = autoService.update(auto, body, id);
    	return resp;
    }

    /**
     * Crear un auto
     * @param auto Instancia de objeto para actualizar
     * @param body Validación de la instancia sobre sus campos
     * @param id del auto
     * @return  String de exito | algun error que haya ocurrido
     */
    @PostMapping("/auto")
    public ResponseEntity<?> crear(@Valid @RequestBody Auto auto, BindingResult body ){
    	ResponseEntity<?> resp = autoService.save(auto, body);
    	return resp;
    }
    
}
