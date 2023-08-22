package com.CodingDojo.Abraham.Controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBase {
	//Peticion GET
		@GetMapping("/tutorial")
		public String home () {
			return "Hola desde SpringBoot!";
		}
		
		@GetMapping("/despliega")
		public String despliegaUsuarios() {
			String usuarios [] = {"Elena", "Juana", "Pablo"};
			String respuesta = "";
			for(String usuario:usuarios) {
				respuesta += "<h2>"+usuario+"</h2>";
			}
			return respuesta;
		}
		
		@GetMapping("/hello")
		public String helloNombre(@RequestParam(value="nombre") String name) {
			return "<h1>Hola "+name+"!</h1>";
		}
		
		@GetMapping("/hello2")
		public String helloNombreApellido(@RequestParam(value="nombre") String name,@RequestParam(value="apellido") String lastName) {
			return "<h1>Hola "+name+" "+lastName+"!</h1>";
		}
		
		@GetMapping("/hola/{nombre}")
		public String helloPath(@PathVariable("nombre") String name){
			return "<h1>Hola "+name+"!</h1>";
		}
		
		@GetMapping("/repite/{palabra}/{numero}")
		public String repite(@PathVariable("palabra")String palabra, @PathVariable("numero")int numero) {
			String respuesta = "";
			for(int i=0; i<numero; i++) {
				respuesta += "<h5>"+palabra+"</h5>";
			}
			return respuesta;
		}
		
		@GetMapping("/vacaciones/{lugar}/{numero}/{nombre}")
		public String vacaciones(@PathVariable("lugar")String lugar, 
							@PathVariable("numero")int numero,
							@PathVariable("nombre")String nombre) {
			
			return nombre+" viajara por el mundo y conocera "+lugar+" el "+numero+" de este mes";
		}
		
}
