package br.com.yurekesley.qualquercoisaapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TBL_ESTOQUE")
public @Data class Estoque {
	
	@Id
	@SequenceGenerator(name = "estoque_id_seq", sequenceName = "estoque_id_seq", initialValue= 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_id_seq")
	private Long id;
	
	@OneToMany
	private List<Produto> itens;

}
