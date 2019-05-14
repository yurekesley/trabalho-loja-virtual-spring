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
@Table(name = "TBL_CLIENTES")
public @Data class Cliente {

	@Id
	@SequenceGenerator(name = "clientes_id_seq", sequenceName = "clientes_id_seq", initialValue= 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_id_seq")
	private Long id;
	
	@Column(length= 255, nullable= false)
	private String nome;

}
