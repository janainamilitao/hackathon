package com.marketpay.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketpay.hackathon.model.Usuario;
import com.marketpay.hackathon.model.dto.UsuarioDTO;
import com.marketpay.hackathon.service.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService  usuarioService;
	
	private static final String APPLICATION_JSON  = "application/json";
	
	@ApiOperation(value = "Criação de usuário", response = UsuarioDTO.class)
	@RequestMapping(value = "/criarUsuario", method= RequestMethod.POST, produces = APPLICATION_JSON )
	public Usuario criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return usuarioService.criarUsuario(usuarioDTO);
	}
	
	

}
