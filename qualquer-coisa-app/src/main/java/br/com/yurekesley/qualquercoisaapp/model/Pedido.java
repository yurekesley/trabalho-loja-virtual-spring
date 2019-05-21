package br.com.yurekesley.qualquercoisaapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "TBL_PEDIDOS")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Pedido.class)
public @Data class Pedido extends Modelo {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "pedidos_id_seq", sequenceName = "pedidos_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "pedido", fetch = FetchType.EAGER)
	private List<ItemPedido> itens;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusPedido status = StatusPedido.PENDENTE;

	public void addItem(ItemPedido item) {
		if (this.itens == null)
			this.itens = new ArrayList<ItemPedido>();

		this.itens.add(item);
	}

	public Pedido() {
	}

	public Pedido(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public List<ItemPedido> getItens() {
		for (ItemPedido itemPedido : this.itens) {
			itemPedido.setPedido(this);
		}
		return this.itens;
	}

}
