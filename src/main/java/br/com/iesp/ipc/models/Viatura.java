package br.com.iesp.ipc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name="tab_viatura")
public class Viatura {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@NotBlank(message="este campo n pode ser vazio")

	@Column
	private String marca;
	
	@Column
	private String modelo;
	
	@Column
	@Pattern(regexp= "[A-Z]{3}-[0-9]{4}")
	private String placa;
	
	@Column
	private String cor;
	
	@Column
	private Long quilometragem;
	
	@Column
	private String prefixo;
	
	@Column(unique = true)
	private String VTR;

	
	
	
}
