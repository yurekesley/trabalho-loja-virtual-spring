package br.com.yurekesley.qualquercoisaapp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "TBL_ITEM_REPOSICAO")
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ItemReposicao.class)
public @Data class ItemReposicao extends Modelo {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "reposicoes_id_seq", sequenceName = "reposicoes_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reposicoes_id_seq")
	private Long id;

	
	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID", nullable = false)
	private Produto produto;

	@Enumerated(EnumType.STRING)
	private StatusReposicao status = StatusReposicao.PENDENTE;
}
