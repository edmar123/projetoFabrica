package br.com.iesp.ipc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.iesp.ipc.enums.TipoViatura;

@Entity
public class Viatura {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String marca;
	
	private String modelo;
	
	private String placa;
	
	private String cor;
	
	private Long quilometragem;
	
	private String prefixo;
	@Column(unique = true)
	private String VTR;
	@Enumerated(EnumType.STRING)
	@Column
	private TipoViatura tipoViatura;
	
}
