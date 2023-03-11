package com.mss.springboot.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.springboot.web.app.models.Cliente;
import com.mss.springboot.web.app.repositories.ClienteRepositorio;


@Service
//	Añadiendo los Metodos de la interfaz IClienteServicio
public class ImplementClienteServicio implements IClienteServicio{
	
	//	Inyeccion de Dependencia
	@Autowired
	ClienteRepositorio clienteRepositorio;
	
	
	//	Metodos propios de la clase "JpaRepository"
	@Override
	public List<Cliente> obtenerTodo() {
		// TODO Auto-generated method stub
		return clienteRepositorio.findAll();	//	Devolviendo todo en la tabla Clientes
	}
	
	
	@Override
	public Cliente guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepositorio.save(cliente);
	}
	
	
	@Override
	public Cliente obtenerPorId(long id) {
		// TODO Auto-generated method stub
		return clienteRepositorio.findById(id).orElse(null);
	}
	
	
	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		clienteRepositorio.deleteById(id);
	}
	
	
}