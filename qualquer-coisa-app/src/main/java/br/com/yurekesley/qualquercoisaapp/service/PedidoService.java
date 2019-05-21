package br.com.yurekesley.qualquercoisaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yurekesley.qualquercoisaapp.model.Cliente;
import br.com.yurekesley.qualquercoisaapp.model.ItemPedido;
import br.com.yurekesley.qualquercoisaapp.model.Pedido;
import br.com.yurekesley.qualquercoisaapp.model.Produto;
import br.com.yurekesley.qualquercoisaapp.repository.PedidoRepository;

@Service
public class PedidoService extends GenericService<Pedido, Long> implements IPedido {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ItemEstoqueService estoqueService;

	@Override
	public void save(Pedido pedido) {

		Cliente cliente = clienteService.findById(pedido.getCliente().getId());

		pedido.setCliente(cliente);

		pedido.getItens().forEach((item -> {

			item = preencherInformacoesDoItem(item);

			this.estoqueService.verificaDisponibilidadeDoProdutoNoEstoque(item.getProduto(), item.getQuantidade());

		}));

		this.repository.save(pedido);
	}

	private ItemPedido preencherInformacoesDoItem(ItemPedido item) {
		Produto produto = produtoService.findById(item.getProduto().getId());
		item.setProduto(produto);
		return item;
	}
}
