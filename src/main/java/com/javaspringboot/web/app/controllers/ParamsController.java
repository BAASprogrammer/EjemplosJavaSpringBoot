package com.javaspringboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/parametros")
public class ParamsController {
//CTRL + Espacio para mostrar anotaciones Spring Boot
//	@GetMapping(value = "/")
//	public String index() {
//		return "parametros/index";
//	}

	@GetMapping("/string")
	public String parametro(@RequestParam(name = "texto",required = false, defaultValue = "sin parametros") String cadena, Model model) {
		model.addAttribute("cadena", "El texto que contiene cadena es : "+cadena);
		return "parametros/index";
	}
}
