package com.prueba.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.crud.models.UserDTO;
import com.prueba.crud.repositories.UserRepository;


/**
 * @author Edwin
 *Esta clase contiene el control y metodos de entrada y salida de la Mongodb  
 */
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.OPTIONS})
@RequestMapping("/api/users")
public class UserController {

	/**
	 *  La anotación @Autowwired permite acceder a las propiedades del repositorio de la DB
	 *  que se encuentran en la clase UserRepository
	 */
	@Autowired
	private UserRepository repository;
	
	/**
	 * Se definen los metodos del CRUD básicos
	 * Se define el parametro u como abreviatura de Usuario
	 * Para acceder a los metodos de la clase UserDTO
	 * y se retorna la respuesta del uso del repositorio de la db
	 */
	
	/**
	 * Se agrega al Mapping la ruta /user para la inserción de un nuevo dato en la db
	 */
	
	@PostMapping("/user")
	public UserDTO create(@Validated @RequestBody UserDTO u) {
		return repository.insert(u);
	}
	
	/**
	 * Se agrega al Mapping el slash "/" para realizar la consulta de los datos de la db  
	 */
	@GetMapping("/")
	public List<UserDTO> readList() {
		return repository.findAll();
	}
	
	/**
	 * Se agrega al Mapping la ruta /user/ junto al parametro {email} para validar que no se repitan los correos
	 *  */
	@GetMapping("/user/{email}")
	public Optional<UserDTO> readListEmail(@PathVariable String email) {
		return repository.findByEmail(email);
	}

	/**
	 * Se agrega al Mapping la ruta /user/ junto al parametro {identification} para validar que no se repitan las identificaciones ocedulas
	 *  */
	@GetMapping("/user/identification/{identification}")
	public Optional<UserDTO> readListIdentification(@PathVariable String identification) {
		return repository.findByIdentification(identification);
	}
		
	/**
	 * Se agrega al Mapping la ruta /user/ junto al parametro {id} que se decea actualizar en la db
	 */
	@PutMapping("/user/{id}")
	public UserDTO update(@PathVariable String id, @Validated @RequestBody UserDTO u) {
		Optional<UserDTO> consulta = repository.findByIdentification(id);
		u.set_id(consulta.get().get_id());
		return repository.save(u);
	}
	
	/**
	 * Se agrega al Mappin la ruta /user/ junto al {id} que se decea eliminar
	 */
	@DeleteMapping("/user/{id}")
	public void delete (@PathVariable String id) {
		repository.deleteById(id);
	}
}
