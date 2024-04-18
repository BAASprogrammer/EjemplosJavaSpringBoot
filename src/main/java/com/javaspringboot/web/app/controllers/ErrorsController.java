package com.javaspringboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController implements ErrorController {
	public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        int statusCode = request.getAttribute("javax.servlet.error.status_code") == null ? 500 : (int) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = request.getAttribute("javax.servlet.error.message") == null ? "Unknown error" : (String) request.getAttribute("javax.servlet.error.message");

        model.addAttribute("statusCode", statusCode);
        model.addAttribute("errorMessage", errorMessage);

        return "error"; // Name of your error view template
    }
}
