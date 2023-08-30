package com.CodingDojo.Abraham.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingDojo.Abraham.Modelos.Direccion;
import com.CodingDojo.Abraham.Modelos.Usuario;
import com.CodingDojo.Abraham.Repositorios.RepositorioDirecciones;
import com.CodingDojo.Abraham.Repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired // No es una instancia
	private RepositorioUsuarios repoUsuario;
	
	@Autowired
	private RepositorioDirecciones repoDir;
	
	// Un metodo que regresa una lista de usuarios
	public List<Usuario> todosUsuarios(){
		return repoUsuario.findAll();
	}
	
	// Guarda un usuario
	public Usuario guardaUsuario(Usuario nuevoUsuario) {
		return repoUsuario.save(nuevoUsuario);
	}
	
	// Me regresa un usuario en base a su ID
	public Usuario buscarUsuario(long id) {
		// SELECT * FROM usuarios WHERE id = <id>
		return repoUsuario.findById(id).orElse(null);
	}
	
	// Borra un usuario
	public void deleteUsuario(long id) {
		repoUsuario.deleteById(id); // DELETE * FROM usuarios WHERE id = <id>
	}
	
	// Actualizar Usuario
	public Usuario updateUsuario(Usuario nuevaInfo, Long id) {
	    Usuario usuarioPorActualizar = repoUsuario.findById(id).orElse(null);

	    if (usuarioPorActualizar != null) {
	        if (nuevaInfo.getNombre() != null) {
	            usuarioPorActualizar.setNombre(nuevaInfo.getNombre());
	        }
	        if (nuevaInfo.getApellido() != null) {
	            usuarioPorActualizar.setApellido(nuevaInfo.getApellido());
	        }
	        if (nuevaInfo.getEmail() != null) {
	            usuarioPorActualizar.setEmail(nuevaInfo.getEmail());
	        }
	        if (nuevaInfo.getPassword() != null) {
	            usuarioPorActualizar.setPassword(nuevaInfo.getPassword());
	        }

	        return repoUsuario.save(usuarioPorActualizar);
	    } else {
	        return null;
	    }
	}
	
	public Direccion guardarDireccion(Direccion nuevaDireccion) {
		return repoDir.save(nuevaDireccion);
	}
	
}
