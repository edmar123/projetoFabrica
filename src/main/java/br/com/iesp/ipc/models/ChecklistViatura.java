package br.com.iesp.ipc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="tab_checkListViatura")
public class ChecklistViatura {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column
	private String pneuSuporte;
	@Column
	private String radioComunicacao;
	@Column
	private String macaco;
	@Column
	private String extintor;
	@Column
	private String mosquetao;
	@Column
	private String caboGuincho;
	@Column
	private String cartaoAbastecimento;
	@Column
	private String triangulo;
	@Column
	private String chaveRoda;
	@Column
	private String CRLv;
	@OneToOne
	private Viatura viatura;







	
}
