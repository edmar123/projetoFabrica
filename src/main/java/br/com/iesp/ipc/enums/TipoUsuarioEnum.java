/**
 * 
 */
package br.com.iesp.ipc.enums;

/**
 * @author Cayo Hollanda (http://www.github.com/cayohollanda)
 * @project desenvolvimento
 */
public enum TipoUsuarioEnum {

	COMUM("Usuário comum"),
    ADMINISTRADOR("Usuário administrador");
	
	private String descricao;
	
	TipoUsuarioEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}
