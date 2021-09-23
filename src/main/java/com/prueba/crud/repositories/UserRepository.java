package com.prueba.crud.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.crud.models.UserDTO;

/**
 * @author Edwin
 *Esta clase contiene el repositorio de la Mongodb
 */
@Repository
public interface UserRepository extends MongoRepository<UserDTO, String>{
	@Query("{ 'email' : ?0 }")
	Optional<UserDTO> findByEmail(String email);
	@Query("{ 'identification' : ?0 }")
	Optional<UserDTO> findByIdentification(String identification);

}
