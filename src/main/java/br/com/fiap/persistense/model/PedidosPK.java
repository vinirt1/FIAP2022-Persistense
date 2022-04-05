package br.com.fiap.persistense.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PedidosPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "nr_unco_pedido")
	private int codigo;
	@Column(name = "cd_prd")
	private int produto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof PedidosPK) {
			PedidosPK pk = (PedidosPK) o;
			if (this.getCodigo() != pk.getCodigo()) {
				return false;
			}
			if (this.getProduto() != pk.getProduto()) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getProduto() + this.getCodigo();
	}
}