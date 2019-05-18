package com.marketpay.hackathon.layout.header;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "layoutspcbrasilheader")
@AllArgsConstructor
@Getter
@Setter
public class LayoutSPCBrasilHeader {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;	
	
	@Column (name = "tipoderegistro")
	private String tipoDeRegistro;
	
	@Column (name = "operacao")
	private String operacao;
	
	@Column (name = "datamovimento")
	private String dataMovimento;
	
	@Column (name = "remessa")
	private String remessa;
	
	@Column (name = "entidade")
	private String entidade;
	
	@Column (name = "associado")
	private String associado;
	
	@Column (name = "datamovimentoarquivo")
	private String dataMovimentoArquivo;
	
	@Column (name = "branco")
	private String branco;
	
	@Column (name = "unidadedenegocio")
	private String unidadeDeNegocio;
	
	@Column (name = "numerodaversao")
	private String numeroDaVersao;
	
	@Column (name = "codigoderetorno")
	private String codigoDeRetorno;
	
	@Column (name = "sequencialderegistro")
	private String sequencialDeRegistro;
	
	
}
