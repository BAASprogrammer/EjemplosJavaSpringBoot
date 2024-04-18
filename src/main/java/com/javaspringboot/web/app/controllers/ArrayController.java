package com.javaspringboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaspringboot.web.app.models.Usuario;

@Controller
@RequestMapping("app")
public class ArrayController {

	@RequestMapping("lista")
	public String lista(Model model) {
		model.addAttribute("titulo", "Probando tipos de listados");
		return "tabladatos";
	}
	
	@RequestMapping("prueba")
	public String prueba(Model model) {
		model.addAttribute("titulo", "Prueba");
		return "tabladatos";
	}

//	Forma de imprimir datos con ArrayList de UTIL (Listado de arreglo)
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listar usuarios con Array");
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andrés", "Roe", "andres@gmail.com"));
		usuarios.add(new Usuario("Mario", "Gómez", "mario@gmail.com"));
		usuarios.add(new Usuario("Biden", "Foo", "biden@gmail.com"));
		usuarios.add(new Usuario("Flor", "Ramírez", "flor@gmail.com"));
		model.addAttribute("usuarios", usuarios);
		return "listado";
	}

// Forma de imprimir datos con asList de UTIL (Arreglo separado por comas)
	@RequestMapping("/listado")
	public String listado(Model model) {
		model.addAttribute("titulo", "Listar usuarios con Array");
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrés", "Roe", "andrea@gmail.com"),
				new Usuario("Mariam", "Gómez", "mariam@gmail.com"), new Usuario("Víctor", "Pop", "victor@gmail.com"),
				new Usuario("Carmen", "Ramírez", "carmen@gmail.com"));
		model.addAttribute("usuarios", usuarios);
		return "listado";
	}

//	Agregando la función como ModelAttribute se puede acceder desde cualquier @RequestMapping (listar, listado, prueba, etc)
	@ModelAttribute("usuarios")
	public List<Usuario> getClientes() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrea", "Roe", "andres@gmail.com"),
				new Usuario("Mario", "Gómez", "mario@gmail.com"), new Usuario("Biden", "Foo", "biden@gmail.com"),
				new Usuario("Flor", "Ramírez", "flor@gmail.com"));
		return usuarios;

	}
}
