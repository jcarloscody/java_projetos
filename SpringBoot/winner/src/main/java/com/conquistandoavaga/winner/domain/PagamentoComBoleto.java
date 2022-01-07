package com.conquistandoavaga.winner.domain;


import java.text.SimpleDateFormat;

import com.conquistandoavaga.winner.domain.enums.EstadoPagamento;

public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private SimpleDateFormat dataVencimento;
	private SimpleDateFormat dataPagamento;
	
	

	public PagamentoComBoleto() {
	}
	
	

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, SimpleDateFormat dataVencimento,
			SimpleDateFormat dataPagamento) {
		super(id, estado, pedido);
		
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		
	}



	public SimpleDateFormat getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(SimpleDateFormat dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public SimpleDateFormat getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(SimpleDateFormat dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	@Override
	public String toString() {
		return "PagamentoComBoleto [dataVencimento=" + dataVencimento + ", dataPagamento=" + dataPagamento + "]";
	}
	
	
	
	
}
