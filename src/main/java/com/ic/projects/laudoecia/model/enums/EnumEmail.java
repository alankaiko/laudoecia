package com.ic.projects.laudoecia.model.enums;

public enum EnumEmail {
	GMAIL("GMAIL"), HOTMAIL("HOTMAIL"), BOL("BOL"), UOL("UOL"), YAHOO("YAHOO"), ZOHO("ZOHO"), KINGHOST("KINGHOST"), OUTROS("OUTROS");
	
	private String valor;
	
	private EnumEmail(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return valor;
	}
	
}
