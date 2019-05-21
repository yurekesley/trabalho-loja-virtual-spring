package br.com.yurekesley.qualquercoisaapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "TBL_PRODUTOS")
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Produto.class)
public @Data class Produto extends Modelo {


	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "produtos_id_seq", sequenceName = "produtos_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_id_seq")
	private Long id;

	@Column
	@NotNull(message = "Campo obrigatório")
	private String nome;

	@Column
	@NotNull(message = "Campo obrigatório")
	private Double valor;

	public Produto() {
	}

	public Produto(Long id) {
		this.id = id;
	}

}
