package br.com.yurekesley.qualquercoisaapp.service;

import br.com.yurekesley.qualquercoisaapp.model.Produto;

public interface IEstoque {

	public Boolean verificarDisponibilidadeDeProdutoEmEstoque(Produto p);

	public void removerProdutoDoEstoque(Produto produto);

	public void adicionarProdutoNoEstoque(Produto produto);
	
	public Integer totalDeProdutos(Produto produto);
	
	public Integer totalDeProdutos();


}
