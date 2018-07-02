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
	
	private String role;
	
	TipoUsuarioEnum(String role){
		this.role = role;
	}
	
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.role;
	}
	
}
