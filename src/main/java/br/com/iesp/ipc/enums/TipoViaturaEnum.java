package br.com.iesp.ipc.enums;




public enum TipoViaturaEnum {
	COMUM("Comum"),
	TRANSPORTE_DE_CORPOS("Transporte de corpos");
	
	private String descricao;
	
	TipoViaturaEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}
