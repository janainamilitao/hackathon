package com.marketpay.hackathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "usuario")
@AllArgsConstructor
@Getter
@Setter
public class Usuario {
	
	@Id
	@SequenceGenerator(name = "conta_seq", sequenceName = "conta_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_seq")
	private Long id;	
	
	@Column (name = "nome")
	@NotEmpty(message="Nome é obrigatório.")
	private String nome;
	
	@Column (name = "email")
	@NotEmpty(message="Email é obrigatório.")
	private String email;
	
	@Column (name = "login")
	@NotEmpty(message="Login é obrigatório.")
	private String login;
	
	@Column (name = "senha")
	@NotEmpty(message="Senha é obrigatória.")
	private String senha;
	
	@Column (name = "ativo")
	private String ativo;
	
	public Usuario(String nome, String email, String login, String senha) {
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}

}
