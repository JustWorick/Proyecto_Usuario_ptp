package com.CodingDojo.Abraham.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CodingDojo.Abraham.Modelos.Usuario;
import com.CodingDojo.Abraham.Servicios.Servicios;

@RestController
public class ControladorAPI {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/api/usuarios")
	public List<Usuario> apiMuestraUsuario(){
		return servicio.todosUsuarios();
	}
	
	@PostMapping("/api/usuarios")
	public Usuario apiCrearUsuario(@RequestParam("nombre") String nombre,
								   @RequestParam("apellido") String apellido,
								   @RequestParam("email") String email,
								   @RequestParam("password") String password){
		
		Usuario nuevoUsuario = new Usuario(nombre,apellido,email,password);
		return servicio.guardaUsuario(nuevoUsuario);
	}
	
	@DeleteMapping("/api/usuarios/{id}")
	public void apiDeleteUsuario(@PathVariable("id") Long id) {
		servicio.deleteUsuario(id);
	}
	
	@PutMapping("/api/usuarios/{id}")
	public ResponseEntity<Usuario> apiUpdateUsuario(@PathVariable("id") Long id, @RequestBody Usuario nuevaInfo){
		
		Usuario usuarioActualizado = servicio.updateUsuario(nuevaInfo, id);
		
		if(usuarioActualizado != null) {
			return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
