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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TBL_REPOSICOES")
public @Data class Reposicao {

	@Id
	@SequenceGenerator(name = "reposicoes_id_seq", sequenceName = "reposicoes_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reposicoes_id_seq")
	private Long id;

	
	@OneToMany
	@JoinTable( name="TBL_REPOSICOES_ITENS", 
	joinColumns = @JoinColumn( name="REPOSICAO_ID"),
	inverseJoinColumns = @JoinColumn( name="PRODUTO_ID"))
	private List<Produto> itens;

	@Enumerated(EnumType.STRING)
	private StatusReposicao status;
}
