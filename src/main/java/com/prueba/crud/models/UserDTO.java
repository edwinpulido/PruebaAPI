package com.prueba.crud.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** 
 *@author Edwin Pulido
 *@version 24/05/2021
 *Esta clase contiene los atributos que seran almacenados en la db
 *con sus metodos de acceso
 */

@Document(collection = "usuarios")
public class UserDTO {
	
	/**
	 * Declaración de atributos privados
	 */
	@Id
	private String _id;

	private String name;

	private String lastname;
	
	private String identification;
	
	private String email;

	private String phone;


	/**
	 * Creación del Getter and Setters
	 * Me retorna los métodos de acceso a los atributos de la clase
	 * id
	 * name -Nombre del Usuario
	 * lastname - Apellido del usuario
	 * identification - cedula del usurio
	 * email - correo del usuario
	 * phone - Telefono del usuario 
	 */
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
