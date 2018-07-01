/**
 * 
 */
package br.com.iesp.ipc.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Cayo Hollanda (http://www.github.com/cayohollanda)
 * @project desenvolvimento
 */
public enum TipoUsuarioEnum implements GrantedAuthority {

	ROLE_COMUM("ROLE_COMUM"),
    ROLE_ADMIN("ROLE_ADMIN");
	
	private String descricao;
	
	TipoUsuarioEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.descricao;
	}
	
}
