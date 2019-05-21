package br.com.yurekesley.qualquercoisaapp.service;

import static org.junit.Assert.assertEquals;

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

public class PedidoServiceTest extends AppTest {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private ProdutoService produtoService;

	private Long clienteId = 1l;
	private Cliente cliente = null;

	private Pedido pedido = null;

	private Produto cd = null;
	private Produto camisa = null;

	private ItemPedido iCd = new ItemPedido();
	private ItemPedido iCamisa = new ItemPedido();

	private List<ItemPedido> items = null;

	@Before
	public void before() {
		this.cliente = this.clienteService.findById(clienteId);

		this.cd = this.produtoService.findById(1l);
		this.camisa = this.produtoService.findById(2l);

		this.pedido = new Pedido();

		this.iCd.setProduto(this.cd);
		this.iCd.setQuantidade(2);
		this.iCd.setPedido(this.pedido);

		this.iCamisa.setProduto(this.camisa);
		this.iCamisa.setQuantidade(3);
		this.iCamisa.setPedido(this.pedido);

		this.items = new ArrayList<ItemPedido>(Arrays.asList(iCd, iCamisa));

		this.pedido.setCliente(cliente);
		this.pedido.setItens((items));
	}

	@Test
	public void deveSalvarPedido() {
		this.pedidoService.save(pedido);
	}

	@Test
	public void deveCalcularTotalLiquido() {
		this.cd.setValor(2.0);

		this.iCd.setQuantidade(10);
		this.iCd.setPedido(this.pedido);
		pedido.setItens((items));

		this.pedidoService.save(pedido);

		assertEquals(Double.valueOf(20.00), this.iCd.getTotalLiquido());

	}

	@Test
	public void deveCalcularValorUnitario() {

		this.cd.setValor(2.0);

		this.iCd.setQuantidade(10);
		this.iCd.setPedido(this.pedido);
		pedido.setItens(items);

		this.pedidoService.save(pedido);

		assertEquals(Double.valueOf(2.0), this.iCd.getValorUnitario());

	}

}
