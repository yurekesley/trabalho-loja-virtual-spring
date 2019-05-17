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

import lombok.Data;

@Entity
@Table(name = "TBL_ITEM")
public @Data class Item {

	@Id
	@SequenceGenerator(name = "item_pedido_id_seq", sequenceName = "item_pedido_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_pedido_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name="PRODUTO_ID", nullable = false)
	private Produto produto;
		
	@Column(updatable = false)
	private Integer quantidade;

	@Column(updatable = false)
	private Double valorUnitario;
	
	@Column(updatable = false)
	private Double totalLiquido;
	
	@ManyToOne
	@JoinColumn(name="PEDIDO_ID", nullable = false)
	private Pedido pedido;
	
	@PrePersist
	public void popularInformacoesDoItem() {
		this.setValorUnitario(this.getProduto().getValor());
		this.setTotalLiquido(this.getValorUnitario() * this.getQuantidade());
	} 
}
