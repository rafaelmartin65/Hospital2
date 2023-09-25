package com.cga.sanidad.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Direccion {

	// atributos
	private String calle;
	private int numero;
	private int cp;

	public Direccion() {

	}

	public Direccion(String calle, int numero, int cp) {
		this.calle = calle;
		this.numero = numero;
		this.cp = cp;
	}

	@Autowired
	public void setCalle(@Value("San Antonio") String calle) {
		this.calle = calle;
	}

	@Autowired
	public void setNumero(@Value("25") int numero) {
		this.numero = numero;
	}

	@Autowired
	public void setCp(@Value("38300") int cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", cp=" + cp + "]";
	}

}
