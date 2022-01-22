package com.example.prueba.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;


/**
 * Entidad para mapear a la tabla de la DB
 */
@Entity
@Table(name = "autos")
public class Auto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	//validaciones para los campos
	//si el atributo tiene un nombre diferente a la tabla real usamos @Column
    @NotBlank( message = "Requerido" )
    private String marca;

	@NotBlank( message = "Requerido" )
    private String modelo;

	@NotBlank( message = "Requerido" )
    private String color;

	@NotBlank( message = "Requerido" )
    private String serie;

	@NotBlank( message = "Requerido" )
    private String placa;
    
    
    
    

	public Auto() {
		super();
	}


	public Auto(Long id, String marca, String modelo, String color, String serie, String placa) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.serie = serie;
		this.placa = placa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
    
    
    

       
    
}
