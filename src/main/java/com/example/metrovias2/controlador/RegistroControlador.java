package com.example.metrovias2.controlador;

import com.example.metrovias2.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.metrovias2.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {

	@Autowired
//	private UsuarioServicio servicio;
	private EmpleadoServicio empleadoServicio;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
//		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		modelo.addAttribute("empl",empleadoServicio.listarTodosLosEmpleados());
		return "index";
	}
}
