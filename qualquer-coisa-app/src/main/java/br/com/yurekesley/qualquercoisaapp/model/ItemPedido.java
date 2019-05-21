package br.com.yurekesley.qualquercoisaapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "TBL_ITEM_PEDIDO")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ItemPedido.class)
public @Data class ItemPedido extends Modelo {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "item_pedido_id_seq", sequenceName = "item_pedido_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_pedido_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID", nullable = false)
	@NotNull(message = "Campo obrigatório")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "PEDIDO_ID", nullable = false)
	@NotNull(message = "Campo obrigatório")
	@JsonIgnore
	private Pedido pedido;

	@Column(updatable = false)
	@NotNull(message = "Campo obrigatório")
	private Integer quantidade;

	@Column(updatable = false)
	private Double valorUnitario;

	@Column(updatable = false)
	private Double totalLiquido;

	public ItemPedido() {
	}

	public ItemPedido(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	@PrePersist
	public void popularInformacoesDoItem() {
		this.setValorUnitario(getProduto().getValor());
		Double valor = this.getValorUnitario() * this.getQuantidade();
		this.setTotalLiquido(valor);
	}

}
