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
@Table(name="tab_checkListViaturaIML")
public class ChecklistViaturaIML extends ChecklistViatura {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column
	private String pranchaColetaCorpo;
	@OneToOne
	private ChecklistViatura  checklistViatura;
	
	







	
}
