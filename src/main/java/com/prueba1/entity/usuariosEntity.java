package com.prueba1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class usuariosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombres;
	private String apellidos;
	private String cedula;
	private String correo;
	private String telefono;
	
}

/*	SCRIPT USERS
 * CREATE TABLE `usuarios` ( `id` int(11) NOT NULL AUTO_INCREMENT, `apellidos`
 * varchar(255) DEFAULT NULL, `cedula` varchar(255) DEFAULT NULL, `correo`
 * varchar(255) DEFAULT NULL, `nombres` varchar(255) DEFAULT NULL, `telefono`
 * varchar(255) DEFAULT NULL, PRIMARY KEY (`id`) ) ENGINE=MyISAM
 * AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
 */
