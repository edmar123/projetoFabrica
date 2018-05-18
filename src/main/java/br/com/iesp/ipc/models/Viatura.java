package br.com.iesp.ipc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.iesp.ipc.enums.TipoViaturaEnum;
import lombok.Data;

@Data
@Entity(name="tab_viatura")
public class Viatura {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column
	private String marca;
	
	@Column
	private String modelo;
	
	@Column
	private String placa;
	
	@Column
	private String cor;
	
	@Column
	private Long quilometragem;
	
	@Column
	private String prefixo;
	
	@Column(unique = true)
	private String VTR;
	
	@Enumerated(EnumType.STRING)
	@Column
	private TipoViaturaEnum tipoViatura;
	
}
