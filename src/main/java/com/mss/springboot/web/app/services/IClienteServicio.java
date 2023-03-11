package com.mss.springboot.web.app.services;

import java.util.List;

import com.mss.springboot.web.app.models.Cliente;


public interface IClienteServicio {
	
	
	/*	Metodos C.R.U.D		*/
	//	Lista de clientes
	public List<Cliente> obtenerTodo();
	
	//	Guardar Cliente
	public Cliente guardar(Cliente cliente);
	
	//	Obtener Cliente por ID
	public Cliente obtenerPorId(long id);
	
	//	Eliminar Cliente
	public void eliminar(long id);
	
	
}