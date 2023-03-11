package com.mss.springboot.web.app.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mss.springboot.web.app.models.Cliente;
import com.mss.springboot.web.app.services.ImplementClienteServicio;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	
	//	Inyeccion de Dependencia
	@Autowired
	ImplementClienteServicio implementClienteServicio;
	
	
	/*	Metodos		*/
	//	Devolviendo la Lista de Clientes
	@GetMapping("/clientes")
	public List<Cliente> obtenerClientes(){
		return implementClienteServicio.obtenerTodo();
	}
	
	
	
	//	Guardar Clientes
	@PostMapping("/guardar")
	public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){
		Cliente nuevo_cliente = implementClienteServicio.guardar(cliente);
		
		return new ResponseEntity<>(nuevo_cliente, HttpStatus.CREATED);
	}
	
	
	
	//	Obtener por su ID
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> obtenerClienteId(@PathVariable long id){
		Cliente clienteObtenidoId = implementClienteServicio.obtenerPorId(id);
		
		return ResponseEntity.ok(clienteObtenidoId);
	}
	
	
	
	//	Actualizar/Modificar Cliente
	@PutMapping("/cliente/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable long id, @RequestBody Cliente cliente){
		Cliente clienteEncontrado = implementClienteServicio.obtenerPorId(id);
		//	Actualizar datos del Cliente
		clienteEncontrado.setNombre(cliente.getNombre());
		clienteEncontrado.setApellidos(cliente.getApellidos());
		clienteEncontrado.setEmail(cliente.getEmail());
		
		//	Crear el nuevo Cliente (actualizado)
		Cliente cliente_actualizado = implementClienteServicio.guardar(clienteEncontrado);
		
		return new ResponseEntity<>(cliente_actualizado, HttpStatus.CREATED);
	}
	
	
	
	//	Eliminar Cliente
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarCliente(@PathVariable long id) {
		//	Llamando ResponseEntity con el metodo eliminar
		this.implementClienteServicio.eliminar(id);
		
		//	Instanciando el HashMap
		HashMap<String, Boolean> estadoClienteEliminado = new HashMap<>();
		//	PUT  a estadoClienteEliminado
		estadoClienteEliminado.put("eliminado", true);
		
		return ResponseEntity.ok(estadoClienteEliminado);
	}
	
	
	
	
}