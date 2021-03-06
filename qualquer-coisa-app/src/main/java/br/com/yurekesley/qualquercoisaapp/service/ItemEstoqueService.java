package br.com.yurekesley.qualquercoisaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yurekesley.qualquercoisaapp.model.ItemEstoque;
import br.com.yurekesley.qualquercoisaapp.model.Produto;
import br.com.yurekesley.qualquercoisaapp.repository.ItemEstoqueRepository;

@Service
public class ItemEstoqueService extends GenericService<ItemEstoque, Long> {

	@Autowired
	private ItemEstoqueRepository repository;

	@Autowired
	private ReposicaoService reposicaoService;

	private Integer quantidadeDeItensDisponiveisNoEstoque(Produto produto) {
		return this.repository.countByProduto(produto);
	}

	private Boolean ehProdutoDisponivelNoEstoque(Produto produto) {
		Integer numeroDeItensDisponiveis = this.quantidadeDeItensDisponiveisNoEstoque(produto);
		return numeroDeItensDisponiveis == 0 ? false : true;

	}

	public void verificaDisponibilidadeDoProdutoNoEstoque(Produto produto, Integer quantidade) {

		for (int i = 1; i <= quantidade; i++) {

			if (ehProdutoDisponivelNoEstoque(produto)) {
				removeItemDoEstoque(produto);
			} else {
				gerarOrdemDeReposicaoParaOProduto(produto);
			}
		}

	}

	private void gerarOrdemDeReposicaoParaOProduto(Produto produto) {
		this.reposicaoService.gerarReposicao(produto);
	}

	private void removeItemDoEstoque(Produto produto) {
		List<ItemEstoque> itemEstoque = repository.findTop1ByProduto(produto);
		itemEstoque.forEach((item) -> repository.delete(item));
	}
}
