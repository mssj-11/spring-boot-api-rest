package com.mss.springboot.web.app.models;

import java.io.Serializable;

//	Implementando la interfaz Serializable
public class Cliente implements Serializable{
	
	//	Variable 
	private static final long serialVersionUID = 1L;
	
	//	Atributos
	private long id;
	private String nombre;
	private String apellidos;
	private String email;
	
	
	//	Constructor vacio
	public Cliente() {
	}


	
	//	Getter and Setter
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
