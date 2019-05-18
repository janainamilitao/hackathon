package com.marketpay.hackathon.layout.detalhe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "layoutspcbrasildetalheconsumidor")
@AllArgsConstructor
@Getter
@Setter
public class LayoutSPCBrasilDetalheConsumidor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;	
	
	@Column (name = "tipoderegistro")
	private String tipoDeRegistro;
	
	@Column (name = "pracadeconcessao")
	private String pracaDeConcessao;
	
	@Column (name = "nome")
	private String nome;
	
	@Column (name = "tipodocumento")
	private String tipoDocumento;
	
	@Column (name = "cpfcnpj")
	private String cpfCnpj;
	
	@Column (name = "rg")
	private String rg;
	
	@Column (name = "datanascimento")
	private String dataNascimento;
	
	@Column (name = "filiacao")
	private String filiacao;
	
	@Column (name = "endereco")
	private String endereco;
	
	@Column (name = "numero")
	private String numero;
	
	@Column (name = "complemento")
	private String complemento;
	
	@Column (name = "bairro")
	private String bairro;
	
	@Column (name = "cep")
	private String cep;
	
	@Column (name = "cidade")
	private String cidade;
	
	@Column (name = "uf")
	private String uf;
	
	@Column (name = "foneddd")
	private String foneDDD;
	
	@Column (name = "branco")
	private String branco;
	
	@Column (name = "fonenumero")
	private String foneNumero;
	
	@Column (name = "codigoretorno")
	private String codigoRetorno;
	
	@Column (name = "sequencialregistro")
	private String sequencialregistro;
	
}
