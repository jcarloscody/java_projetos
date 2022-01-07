package com.conquistandoavaga.winner.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private SimpleDateFormat instant ;//= new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	
	private Cliente cliente;
	
	private Endereco endereco;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, SimpleDateFormat instant, Pagamento pagamento) {
		super();
		this.id = id;
		this.instant = instant;
		this.pagamento = pagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SimpleDateFormat getInstant() {
		return instant;
	}

	public void setInstant(SimpleDateFormat instant) {
		this.instant = instant;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", instant=" + instant + ", pagamento=" + pagamento + "]";
	}
	
	
	
	
}
