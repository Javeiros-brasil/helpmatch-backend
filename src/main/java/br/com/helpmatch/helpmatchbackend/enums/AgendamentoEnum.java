package br.com.helpmatch.helpmatchbackend.enums;

public enum AgendamentoEnum {
	
	AGENDADO(1),
	INICIADO(2),
	CONCLUIDO(3),
	CANCELADO(4);
	
	AgendamentoEnum(int status) {
		this.status = status;
	}
	
	private int status;
	
}
