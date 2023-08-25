package com.CodingDojo.Abraham.Controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CodingDojo.Abraham.Modelos.Usuario;
import com.CodingDojo.Abraham.Servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		
		model.addAttribute("titulo", "Usuarios");
		
		String usuarios [] = {"Juan","Marcos","Emily","Dana"};
		model.addAttribute("listaUsuarios", usuarios);
		
		HashMap<String, String> paises = new HashMap<String, String>();
		paises.put("Mexico", "CDMX");
		paises.put("Chile", "Santiago");
		paises.put("Argentina", "Buenos Aires");
		
		model.addAttribute("paises", paises);
		
		return "usuarios.jsp";
	}
	
	/* Para formularios necesitamos 2 rutas, una que muestre el formulario y otra que reciba el formulario*/
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario.jsp";
	}
	
	@PostMapping("/registrarme")
	public String registrarme(@RequestParam(value="nombre")String name,
							  @RequestParam(value="email") String correo,
							  RedirectAttributes flash, /* Permite enviar mensajes de validacion */
							  HttpSession session /* Permite guardar informacion en session */) {
		
		if(name.equals("")) {
			flash.addFlashAttribute("error","No has escrito el nombre");
			return "redirect:/formulario";
		}
		
		System.out.println(name);
		System.out.println(correo);
		
		session.setAttribute("nombreUsuario", name);
		
		return "redirect:/bienvenida";
	}

	@GetMapping("/bienvenida")
	public String bienvenida(HttpSession session) {
		Object name = session.getAttribute("name");
		if(name != null) {
			String nombre = (String) name;
			System.out.println("El nombre guardado es: "+nombre);
		}else {
			System.out.println("No se ha registrado");
		}
		return "bienvenida.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		List<Usuario> usuarios = servicio.todosUsuarios();
		model.addAttribute("usuarios", usuarios);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("usuario")Usuario usuario) {
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")  // @Valid permite validar la informacion de un objeto
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		
		if(result.hasErrors()) {
			return "nuevo.jsp";
		}else {
			servicio.guardaUsuario(usuario);
		}
		return "redirect:/dashboard";
	}
}
