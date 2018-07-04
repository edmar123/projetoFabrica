package br.com.iesp.ipc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import br.com.iesp.ipc.enums.TipoViaturaEnum;
import lombok.Data;

@Data
@Entity(name="tab_viatura")
public class Viatura {
	
	
	@Id
	@GeneratedValue
	private Long id;

	@Column()
	@Length(min=3, max=20, message="O campo marca não pode ser vazio")
	private String marca;
	
	
	@Column
	@Length(min=3, max=20, message="O campo modelo não pode ser vazio")
	private String modelo;
	
	@Column(unique = true)
	@Pattern(regexp= "[A-Z]{3}-[0-9]{4}", message="o campo placa deve conter tres letras seguidas de um '-' e 4 numeros")
	private String placa;
	
	@Column
	@Length(min=3, max=20, message="O campo cor não pode ser vazio")
	private String cor;
	
	
	@Column
	@Length(min=3, max=20, message="O campo prefixo não pode ser vazio")
	private String prefixo;
		
	
	@Column(nullable=false)
	private TipoViaturaEnum tipoViaturaEnum;

	
}
