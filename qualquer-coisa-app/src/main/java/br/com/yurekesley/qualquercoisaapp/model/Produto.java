package br.com.yurekesley.qualquercoisaapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TBL_PRODUTOS")
public @Data class Produto {

	@Id
	@SequenceGenerator(name = "produtos_id_seq", sequenceName = "produtos_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_id_seq")
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private Double valor;

}
