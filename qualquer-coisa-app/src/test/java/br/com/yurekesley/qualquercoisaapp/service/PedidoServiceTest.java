
package br.com.yurekesley.qualquercoisaapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.yurekesley.qualquercoisaapp.AppTest;
import br.com.yurekesley.qualquercoisaapp.model.Cliente;
import br.com.yurekesley.qualquercoisaapp.model.ItemPedido;
import br.com.yurekesley.qualquercoisaapp.model.Pedido;
import br.com.yurekesley.qualquercoisaapp.model.Produto;
import br.com.yurekesley.qualquercoisaapp.service.ClienteService;
import br.com.yurekesley.qualquercoisaapp.service.PedidoService;
import br.com.yurekesley.qualquercoisaapp.service.ProdutoService;

public class PedidoServiceTest extends AppTest {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PedidoService pedidoService;
		
	@Autowired
	private ProdutoService produtoService;

	private Long clienteId = 1l;
	private Cliente cliente = null;

	private Produto produto = null;
	private Long produtoId = 1l;

	private Pedido pedido = null;

	private ItemPedido item = new ItemPedido();

	private List<ItemPedido> items = null;

	@Before
	public void before() {
		this.cliente = this.clienteService.findById(clienteId);
		this.produto = this.produtoService.findById(produtoId);

		this.pedido = new Pedido();

		this.item.setProduto(this.produto);
		this.item.setQuantidade(10);
		this.item.setPedido(this.pedido);
		this.items = new ArrayList<ItemPedido>(Arrays.asList(item));
		
		
		this.pedido.setCliente(cliente);
		this.pedido.setItens((items));
	}

	@After
	public void after() {
		this.pedidoService.deleteAll();
	}

	@Test
	public void deveSalvarPedido() {

	
		this.pedidoService.save(pedido);

		assertNotEquals(null, this.pedidoService.findById(pedido.getId()));
		this.pedidoService.deleteById(pedido.getId());

	}

	@Test
	public void deveCalcularTotalLiquido() {
		this.produto.setValor(2.0);

		this.item.setQuantidade(10);
		this.item.setPedido(this.pedido);
		pedido.setItens((items));

		this.pedidoService.save(pedido);	
		
		assertEquals(Double.valueOf(20.00), this.item.getTotalLiquido());

	}
	
	
	@Test
	public void deveCalcularValorUnitario() {
		
		this.produto.setValor(2.0);

		this.item.setQuantidade(10);
		this.item.setPedido(this.pedido);
		pedido.setItens(items);


		this.pedidoService.save(pedido);	

		assertEquals(Double.valueOf(2.0), this.item.getValorUnitario());

		
	}

}
