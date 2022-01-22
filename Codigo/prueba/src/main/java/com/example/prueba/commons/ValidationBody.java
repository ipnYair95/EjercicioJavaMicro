package com.example.prueba.commons;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase empleada para recorrer los campos que no son válidos
 */
public class ValidationBody {

	/**
	 * Metodo para recorrer los campos inválidos y ser agregados a un Map custom
	 * @param result BindingResult de spring boot que contiene las validaciones
	 * @return Map con los pares "atributo o campo invalido":"descripcion"
	 */
	public static Map<String,Object> validar(BindingResult result) {

		Map<String, Object> errores = new HashMap<>();

		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "Campo " + err.getField() + " " + err.getDefaultMessage());
		});

		return errores;

	}

}
