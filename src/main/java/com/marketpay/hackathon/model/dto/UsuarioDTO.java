package com.marketpay.hackathon.model.dto;

import javax.validation.constraints.NotEmpty;

import com.marketpay.hackathon.model.Usuario;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsuarioDTO {
	
	private Long id;
	
	@ApiModelProperty(value="Nome")
	@NotEmpty
	private String nome;
	
	@ApiModelProperty(value="Email")
	@NotEmpty
	private String email;
	
	
	@ApiModelProperty(value="Login")
	@NotEmpty
	private String login;
	
	@ApiModelProperty(value="Senha")
	@NotEmpty
	private String senha;
	
	@ApiModelProperty(value="Status - Ativo (S ou N)")
	@NotEmpty
	private String ativo;
	
	public Usuario transformaParaObjeto() {
		return new Usuario(nome, email, login, senha);
	}

}
