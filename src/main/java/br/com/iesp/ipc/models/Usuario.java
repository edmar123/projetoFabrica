/**
 * 
 */
package br.com.iesp.ipc.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
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
public class Usuario  implements UserDetails{
	
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
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validadeCarteiraHabilitacao;
	
	@Column
	private String tipoCNH;
	
	@ManyToMany
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(
		name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(
		name = "role_id", referencedColumnName="id"))
	private List<Role> roles;

	
	@Column(unique=true)
	@Email
	private String email;
	
	@Column
	private String ativo;
	
	@Column
	@Transient
	private String novaSenha;
	
	@Column
	@Transient
	private String confirmaSenha;
	
	
	
	@PrePersist
	public void pre() {
		this.setSenhaUsuario(new BCryptPasswordEncoder().encode(this.getSenhaUsuario()));
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection <? extends GrantedAuthority>) this.roles ;
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senhaUsuario;
	}



	@Override
	public String getUsername() {
		
		return this.nomeUsuario;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

	
}
