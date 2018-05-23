/**
 * 
 */
package br.com.iesp.ipc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.iesp.ipc.enums.TipoUsuarioEnum;
import lombok.Data;

/**
 * @author Cayo Hollanda (http://www.github.com/cayohollanda)
 * @project desenvolvimento
 */

@Entity
@Data
@Table(name = "tab_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int numeroMatricula;
	
	@Column
	private String nomeCompleto;
	
	@Column
	private String nomeUsuario;
	
	@Column
	private String senhaUsuario;
	
	@Column
	private int lotacaoUsuarioAlocado;
	
	@Column
	private Date validadeCarteiraHabilitacao;
	
	@Column
	private TipoUsuarioEnum tipoUsuario;
	
	@Column
	@Email
	private String email;
	
	@PrePersist
	public void pre() {
		this.setSenhaUsuario(new BCryptPasswordEncoder().encode(this.getSenhaUsuario()));
	}
	
}
