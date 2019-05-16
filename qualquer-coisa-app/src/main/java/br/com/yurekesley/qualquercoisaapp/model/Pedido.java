package br.com.yurekesley.qualquercoisaapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TBL_PEDIDOS")
public @Data class Pedido {

	@Id
	@SequenceGenerator(name = "pedidos_id_seq", sequenceName = "pedidos_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name="cliente_id", nullable=false)
	private Cliente cliente;
	
	@OneToMany
	@JoinTable( name="TBL_PEDIDOS_ITENS", 
	joinColumns = @JoinColumn( name="PEDIDO_ID"),
	inverseJoinColumns = @JoinColumn( name="PRODUTO_ID"))
	private List<ItemPedido> items;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;
}
