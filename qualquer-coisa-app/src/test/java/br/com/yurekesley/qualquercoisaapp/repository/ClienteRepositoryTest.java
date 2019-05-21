package br.com.yurekesley.qualquercoisaapp.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.yurekesley.qualquercoisaapp.model.Cliente;
import br.com.yurekesley.qualquercoisaapp.model.ItemPedido;
import br.com.yurekesley.qualquercoisaapp.model.Pedido;
import br.com.yurekesley.qualquercoisaapp.model.Produto;

public class ClienteRepositoryTest extends RepositoryTest {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	private Cliente cliente;

	@Before
	public void before() {
		cliente = new Cliente();
		cliente.setNome("Jair Bolsonaro");
		assertNotEquals(repository, null);
		assertNotEquals(cliente, null);
		repository.save(this.cliente);
	}

	@Test
	public void deveInserirCliente() {
		cliente = new Cliente();
		cliente.setNome("José Da Silva");
		repository.save(this.cliente);
	}

	@Test
	public void deveBuscarClientes() {
		List<Cliente> clientes = repository.findAll();
		assertNotEquals(clientes, null);
	}

	@Test
	public void deveBuscarPorNome() {
		Cliente cliente = repository.buscarPorNome("Jair Bolsonaro");
		assertNotEquals(cliente, null);
	}

	@Test
	public void deveCriarPedidoParaOCliente() {

		Cliente cliente = repository.buscarPorNome("Jair Bolsonaro");

		Produto produto = new Produto();
		produto.setNome("SAPATO 49");
		produto.setValor(100.0);
		produtoRepository.save(produto);
		assertNotEquals(produto.getId(), null);

		ItemPedido item = new ItemPedido(produto, 4);

		Pedido pedido = new Pedido(Arrays.asList(item));
		Pedido pedido2 = new Pedido(Arrays.asList(item));

		cliente.adicionarPedido(pedido);
		cliente.adicionarPedido(pedido2);

		pedidoRepository.save(pedido);
		assertNotEquals(pedido.getItens().get(0).getPedido(), null);

		assertNotEquals(item.getId(), null);
		repository.save(cliente);

		assertEquals(Double.valueOf(400.0), item.getTotalLiquido());
		assertNotEquals(cliente.getPedidos(), null);

	}

}
