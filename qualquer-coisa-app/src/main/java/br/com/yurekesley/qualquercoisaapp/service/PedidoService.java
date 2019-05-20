package br.com.yurekesley.qualquercoisaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yurekesley.qualquercoisaapp.model.Pedido;
import br.com.yurekesley.qualquercoisaapp.model.Produto;
import br.com.yurekesley.qualquercoisaapp.repository.PedidoRepository;

@Service
public class PedidoService extends GenericService<Pedido, Long> implements IPedido {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ItemEstoqueService estoqueService;

	@Override
	public void save(Pedido pedido) {

		pedido.getItens().forEach((item -> {

			Produto produto = item.getProduto();
			Integer quantidade = item.getQuantidade();

			this.estoqueService.removerItemDoEstoque(produto, quantidade);

		}));

		this.repository.save(pedido);
	}
}
