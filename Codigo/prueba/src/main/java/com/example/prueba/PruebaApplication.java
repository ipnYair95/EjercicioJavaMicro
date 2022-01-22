package com.example.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main de spring boot, todos los componentes, modelos y clases deben estar dentro del paquete que incluye
 * está clase, de lo contrario no serán reconocidos por spring.
 * En caso de ser necesario solamente es usar el ComponentScan
 */
@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PruebaApplication.class, args);
	}

}
