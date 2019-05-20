package br.com.yurekesley.qualquercoisaapp.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.yurekesley.qualquercoisaapp.AppTest;
import br.com.yurekesley.qualquercoisaapp.model.Produto;
import br.com.yurekesley.qualquercoisaapp.service.ProdutoService;

public class ProdutoServiceTest extends AppTest {

	
	@Autowired
	private ProdutoService produtoService;
	private Produto produto;
	private Long id = 1l;
	
	@Before
	public void before() {
		// produto = this.produtoService.findById(this.id);
	}
	
	@After
	public void after() {
	}
	
	@Test
	public void deveBuscarProduto() {
		produto = this.produtoService.findById(this.id);
		assertEquals(this.id, produto.getId());
	}
	
}
