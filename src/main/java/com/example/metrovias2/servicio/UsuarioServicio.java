package com.example.metrovias2.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.metrovias2.controlador.dto.UsuarioRegistroDTO;
import com.example.metrovias2.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();


	
}
