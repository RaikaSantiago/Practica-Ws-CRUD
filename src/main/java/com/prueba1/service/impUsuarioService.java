package com.prueba1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba1.entity.messaje;
import com.prueba1.entity.messajeSimple;
import com.prueba1.entity.usuariosEntity;
import com.prueba1.repository.usuariosRepository;


@Service
public class impUsuarioService implements usuarioService {
	
	@Autowired
    private usuariosRepository usuarioRepository;

	@Override
	public List<usuariosEntity> obtenerUsuarios() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public messaje editarUsuario(usuariosEntity usuario) {
		
		Optional<usuariosEntity> usuarioDB = this.obtenerUsuarioId(usuario.getId());

		usuariosEntity usuarioUpdate = new usuariosEntity();
		messaje msj = new messaje();
		
		if (usuarioDB.isEmpty()) {
			msj.setDescripcion("No se encontro usuario ó fue eliminado");
			msj.setStatus(204);
			msj.setUsuario(null);
			return  msj;
		}
		
		usuariosEntity usuarioCedDB = this.obtenerCedula(usuario.getCedula().trim());
		
		if( usuarioCedDB != null) {
			if ((usuarioCedDB.getId() != usuario.getId())) {
				msj.setDescripcion("La cédula ya se encuentra registrada.");
				msj.setStatus(400);
				msj.setUsuario(usuarioCedDB);
				return msj; 
			}
		}
		
		usuariosEntity usuarioCorreoDB = this.obtenerCorreo(usuario.getCorreo().trim());
		
		if(usuarioCorreoDB != null) {
			if ((usuarioCorreoDB.getId() != usuario.getId())) {
				msj.setDescripcion("El correo ya se encuentra registrado.");
				msj.setStatus(400);
				msj.setUsuario(usuarioCorreoDB);
				return msj; 
			}
		}
		
		usuarioUpdate = usuarioRepository.save(usuario);
		msj.setDescripcion("Usuario actualizado");
		msj.setStatus(200);
		msj.setUsuario(usuarioUpdate);
		
		return msj;
	}

	@Override
	public messaje guardarUsuario(usuariosEntity usuario) {
		
		messaje msj = new messaje();
		usuariosEntity usuarioCedDB = this.obtenerCedula(usuario.getCedula().trim());
		
		if (usuarioCedDB != null) {
			msj.setDescripcion("La cédula ya se encuentra registrada.");
			msj.setStatus(400);
			msj.setUsuario(usuarioCedDB);
			return msj; 
		}
		
		usuariosEntity usuarioCorreoDB = this.obtenerCorreo(usuario.getCorreo().trim());
		
		if (usuarioCorreoDB != null) {
			msj.setDescripcion("El correo ya se encuentra registrado.");
			msj.setStatus(400);
			msj.setUsuario(usuarioCorreoDB);
			return msj; 
		}
		
		usuariosEntity usuarioSave = new usuariosEntity();
		
		usuarioSave = usuarioRepository.save(usuario);
		msj.setDescripcion("Usuario Guardado");
		msj.setStatus(201);
		msj.setUsuario(usuarioSave);
		
		return msj;
	}

	@Override
	public Optional<usuariosEntity> obtenerUsuarioId(Integer id) {
		return this.usuarioRepository.findById(id);
	}

	@Override
	public messajeSimple eliminarUsuario(Integer id) {
		
		messajeSimple msj = new messajeSimple();
		
		this.usuarioRepository.deleteById(id);
				
		msj.setDescripcion("Usuario Eliminado");
		msj.setStatus(200);
		
		return msj;
	}

	@Override
	public usuariosEntity obtenerCedula(String cedula) {
		return this.usuarioRepository.findByCedula(cedula);
	}

	@Override
	public usuariosEntity obtenerCorreo(String cedula) {
		return this.usuarioRepository.findByCorreo(cedula);
	}

	

}
