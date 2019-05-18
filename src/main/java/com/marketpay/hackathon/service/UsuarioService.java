package com.marketpay.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketpay.hackathon.model.Usuario;
import com.marketpay.hackathon.model.dto.UsuarioDTO;
import com.marketpay.hackathon.repository.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario> {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioDTO.transformaParaObjeto();
		usuario.setAtivo("S");
		return usuarioRepository.saveAndFlush(usuario);
	}	
}
