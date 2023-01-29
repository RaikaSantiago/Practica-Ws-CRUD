package com.prueba1.service;

import java.util.List;
import java.util.Optional;

import com.prueba1.entity.messaje;
import com.prueba1.entity.messajeSimple;
import com.prueba1.entity.usuariosEntity;



public interface usuarioService {
	
	List<usuariosEntity> obtenerUsuarios();
	
	messaje editarUsuario(usuariosEntity usuario);
	
	messaje guardarUsuario(usuariosEntity usuario);
	
	Optional<usuariosEntity> obtenerUsuarioId(Integer id);
	
	messajeSimple eliminarUsuario(Integer id);
	
	usuariosEntity obtenerCedula(String cedula);
	
	usuariosEntity obtenerCorreo(String cedula);

}
