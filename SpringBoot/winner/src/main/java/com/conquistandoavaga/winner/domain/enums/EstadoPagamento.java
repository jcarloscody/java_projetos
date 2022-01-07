package com.conquistandoavaga.winner.domain.enums;

public enum EstadoPagamento {
	
	Pendente(1, "Pendente"),
	Quitado(2, "Quitado"),
	Cancelado(3, "Cancelado");
	
	private int cod;
	private String status;
	
	private EstadoPagamento(int cod, String status) {
		this.cod = cod;
		this.status = status;
	}

	public int getCod() {
		return cod;
	}

	public String getStatus() {
		return status;
	}

	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(EstadoPagamento e : EstadoPagamento.values()) {
			if (cod.equals(e.getCod())) {
				return e;
			}
		}
		
		throw new IllegalArgumentException("Erro no ID");

	}
	
}
