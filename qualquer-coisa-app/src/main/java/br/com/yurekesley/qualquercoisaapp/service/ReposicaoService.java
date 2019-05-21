package br.com.yurekesley.qualquercoisaapp.service;

import org.springframework.stereotype.Service;

import br.com.yurekesley.qualquercoisaapp.model.Produto;
import br.com.yurekesley.qualquercoisaapp.model.ItemReposicao;

@Service
public class ReposicaoService extends GenericService<ItemReposicao, Long> {
	
	public void gerarReposicao(Produto produto) {
		ItemReposicao reposicao = new ItemReposicao();
		reposicao.setProduto(produto);				
		this.save(reposicao);
		
	}
}
