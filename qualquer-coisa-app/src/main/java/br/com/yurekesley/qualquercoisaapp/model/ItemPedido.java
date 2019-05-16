package br.com.yurekesley.qualquercoisaapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TBL_ITEM_PEDIDO")
public @Data class ItemPedido {

	@Id
	@SequenceGenerator(name = "item_pedido_id_seq", sequenceName = "item_pedido_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_pedido_id_seq")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUTO_ID", referencedColumnName = "id")
	private Produto poduto;
	
	@Column
	private Integer quantidade;
	
}
