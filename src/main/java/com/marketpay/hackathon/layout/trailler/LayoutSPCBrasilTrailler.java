package com.marketpay.hackathon.layout.trailler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "layoutspcbrasiltrailler")
@AllArgsConstructor
@Getter
@Setter
public class LayoutSPCBrasilTrailler {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;	
	
	@Column (name = "tipoderegistro")
	private String tipoDeRegistro;
	
	@Column (name = "totalderegistros")
	private String totalDeRegistros;
	
	@Column (name = "branco")
	private String branco;
	
	@Column (name = "codigoderetorno")
	private String codigoDeRetorno;
	
	@Column (name = "sequencialderegistro")
	private String sequencialDeRegistro;
	
}
