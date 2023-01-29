package com.prueba1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba1.entity.messaje;
import com.prueba1.entity.messajeSimple;
import com.prueba1.entity.usuariosEntity;
import com.prueba1.service.usuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class usuariosController {
	
	@Autowired
    private usuarioService usuarioService;
	
	@GetMapping("/get")
	public ResponseEntity<List<usuariosEntity>> obtenerUsuarios() {
		return new ResponseEntity<>(this.usuarioService.obtenerUsuarios(), HttpStatus.OK);
	}
	
	@GetMapping("/search/{idUser}")
	public ResponseEntity<Optional<usuariosEntity>> guardarUsuario(@PathVariable("idUser") String idUser) {
		int id = Integer.parseInt(idUser);
		return new ResponseEntity<>(this.usuarioService.obtenerUsuarioId(id), HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public ResponseEntity<messaje> editarUsuario(@RequestBody usuariosEntity usuario) {
		return new ResponseEntity<>(this.usuarioService.editarUsuario(usuario), HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<messaje> guardarUsuario(@RequestBody usuariosEntity usuario) {
		return new ResponseEntity<>(this.usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{idUser}")
	public ResponseEntity<messajeSimple> eliminarUsuario(@PathVariable("idUser") String idUser) {
		int id = Integer.parseInt(idUser);
		return new ResponseEntity<>(this.usuarioService.eliminarUsuario(id), HttpStatus.OK);
	}
	
	
}
