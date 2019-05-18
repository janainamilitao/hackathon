package com.marketpay.hackathon.layout.header;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "layoutboavistaheader")
@AllArgsConstructor
@Getter
@Setter
public class LayoutBoaVistaHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;	
	
	
}
