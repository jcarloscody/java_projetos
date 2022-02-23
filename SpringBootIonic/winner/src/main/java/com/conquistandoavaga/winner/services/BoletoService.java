package com.conquistandoavaga.winner.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.conquistandoavaga.winner.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto ogt, Date instatedoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instatedoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		ogt.setDataVencimento(cal.getTime());
	}
}
