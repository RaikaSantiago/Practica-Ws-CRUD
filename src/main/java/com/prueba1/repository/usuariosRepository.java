package com.prueba1.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba1.entity.usuariosEntity;

public interface usuariosRepository extends JpaRepository<usuariosEntity, Integer> {
	
	usuariosEntity findByCedula(String cedula);
	usuariosEntity findByCorreo(String correo);

}
