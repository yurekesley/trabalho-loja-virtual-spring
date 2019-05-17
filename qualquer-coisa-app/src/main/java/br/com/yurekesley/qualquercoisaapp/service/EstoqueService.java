package br.com.yurekesley.qualquercoisaapp.service;

import org.springframework.stereotype.Service;

import br.com.yurekesley.qualquercoisaapp.model.Estoque;

@Service
public class EstoqueService extends GenericService<Estoque, Long>{

	boolean verificarDisponibilidadeDeProdutoEmEstoque() {
		return true;
	}
	
}
