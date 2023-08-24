package com.CodingDojo.Abraham.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;
import com.CodingDojo.Abraham.Modelos.Usuario;

// @Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
	
	List<Usuario> findAll(); // SELECT * FROM usuarios 
	
	// INSERT INTO usuarios (nombre, apellido, etc...)
	// UPDATE usuarios SET nombre = Valor del objeto
	@SuppressWarnings("unchecked")
	Usuario save(Usuario nuevoUsuario); //Recibimos objeto usuario
	
	// Queries dinamicos
	// SELECT * FROM usuarios WHERE email = email que recibimos en el metodo
	List<Usuario> findByEmail(String email);	
	
	// SELECT * FROM usuarios WHERE nombre = nombre que recibimos
	List<Usuario> findByNombre(String nombre);
	
	// SELECT * FROM usuarios WHERE nombre LIKE "<letras>%" = nombre que recibimos
	List<Usuario> findByNombreStartingWith(String letras);
}
