package br.com.yurekesley.qualquercoisaapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "TBL_CLIENTES")
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Cliente.class)
public @Data class Cliente extends Modelo {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "clientes_id_seq", sequenceName = "clientes_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_id_seq")
	private Long id;

	@Column(length = 255, nullable = false)
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
	private List<Pedido> pedidos;

	public void adicionarPedido(Pedido pedio) {
		if (this.pedidos == null)
			this.pedidos = new ArrayList<Pedido>();

		this.pedidos.add(pedio);
	}

}
