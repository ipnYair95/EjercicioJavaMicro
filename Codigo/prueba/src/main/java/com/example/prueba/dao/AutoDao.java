package com.example.prueba.dao;

import com.example.prueba.entity.Auto;
import org.springframework.data.repository.CrudRepository;

/**
 * Fachada que nos va proveer de metodos empleando JPA y Hibernate para realizar Querys
 * CrudRepository es una clase que nos provee Spring Jpa con los métodos comunes para un CRUD
 * Se pueden agregar metodos personalizados empleando JPQL
 */
public interface AutoDao extends CrudRepository<Auto,Long> {

}
