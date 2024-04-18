package com.javaspringboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaspringboot.web.app.models.Usuario;

@Controller
@RequestMapping("/principal") //relacionar url principal, que se utilizará para llamar a los demás métodos
public class IndexController {
	@GetMapping(value = "/")
	public String index() {
		return "principal/index";
	}
	/* Mapear = relacionar el método a una ruta url, si no se indica tipo de método
	de petición se asume que es GET, si no sería @RequestMapping(value="/index", method=RequestMethod.GET)
	o también utilizar GetMapping si se usa GET o PostMapping si es POST, etc. */
	@RequestMapping(value="/index") //index.html
	public String index(Model model4) { //se puede ocupar Model o ModelMap o Map o ModelAndView
		//se agregan atributo titulo que se utiliza en el index.html, llamándolo ${titulo}
		Usuario user = new Usuario();
		user.setNombre("Pedro");
		user.setApellido("Pascal");
		user.setCorreo("prueba@gmail.com");
		model4.addAttribute("titulo", "Probando Spring Boot");
		model4.addAttribute("usuario", user);
		model4.addAttribute("correo", "Prueba usuario perfil");
		return "principal/index"; 
	}
	//	Si en index.html se ocupa la clase <Usuario> y se llama a este requestmapping que no la ocupa, saldrá error 500
	@RequestMapping(value="/hola") //index.html
	public String hola(Model model2) { //se puede ocupar Model o ModelMap o Map o ModelAndView
		//se agregan atributo titulo que se utiliza en el index.html, llamándolo ${titulo}
		model2.addAttribute("titulo", "Probando Spring Boot 2");
		return "principal/index"; 
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model3) {
		Usuario user = new Usuario();
		user.setNombre("Pedro");
		user.setApellido("Pascal");
		user.setCorreo("prueba@gmail.com");
		model3.addAttribute("usuario", user);
		model3.addAttribute("titulo", "Prueba usuario perfil");
		model3.addAttribute("correo", "Prueba usuario perfil");
		return "principal/index";
	}
	
//	Agregando la función como ModelAttribute se puede acceder desde cualquier @RequestMapping (index, hola, perfil, etc)
	@ModelAttribute("usuarios")
	public List<Usuario> getClientes() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrea", "Roe", "andres@gmail.com"),
				new Usuario("Mario", "Gómez", "mario@gmail.com"), new Usuario("Biden", "Foo", "biden@gmail.com"),
				new Usuario("Flor", "Ramírez", "flor@gmail.com"));
		return usuarios;

	}
}
 