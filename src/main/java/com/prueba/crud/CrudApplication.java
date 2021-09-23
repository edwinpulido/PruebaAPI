package com.prueba.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;

/**
 * @author Edwin
 * Esta es la Clase principal del sistema
 */
@SpringBootApplication
@EnableSwagger2
public class CrudApplication {
	
	@Bean
	  public Docket UsuariosApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select() 
	        .apis(RequestHandlerSelectors.any()) 
	        .paths(PathSelectors.any()) 
	        .build(); 
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
