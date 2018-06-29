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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
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
	
	@Column(unique=true)
	private Long numeroMatricula;
	
	@Column
	private String nomeCompleto;
	
	@Column(unique=true)
	private String nomeUsuario;
	
	@Column
	private String senhaUsuario;
	
	@Column
	private String lotacao;
	
	@Column
	private String orgaoEmissor;
	
	@Column
	private String uf;
	
	@Column
	private String numeroCarteiraHabilitacao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date validadeCarteiraHabilitacao;
	
	@Column
	private String tipoCNH;
	
	@Column
	private TipoUsuarioEnum tipoUsuario;
	
	@Column(unique=true)
	@Email
	private String email;
	
	@Column
	private boolean ativo;
	
	@Transient 
	private String MensagemAtivo;
	
	@PrePersist
	public void pre() {
		this.setSenhaUsuario(new BCryptPasswordEncoder().encode(this.getSenhaUsuario()));
	}
	

	
}
