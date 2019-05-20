package br.com.yurekesley.qualquercoisaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yurekesley.qualquercoisaapp.model.Estoque;
import br.com.yurekesley.qualquercoisaapp.model.Produto;
import br.com.yurekesley.qualquercoisaapp.repository.EstoqueRepository;

@Service
public class EstoqueService extends GenericService<Estoque, Long> implements IEstoque {
	
	@Autowired
	private EstoqueRepository repository;

	@Override
	public Boolean verificarDisponibilidadeDeProdutoEmEstoque(Produto p) {

		return null;
	}

	@Override
	public void removerProdutoDoEstoque(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarProdutoNoEstoque(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer totalDeProdutos(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer totalDeProdutos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
