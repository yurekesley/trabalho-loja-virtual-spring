package br.com.yurekesley.qualquercoisaapp.repository;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.yurekesley.qualquercoisaapp.AppTest;
import br.com.yurekesley.qualquercoisaapp.model.Estoque;
import br.com.yurekesley.qualquercoisaapp.model.Produto;

public class EstoqueRepositoryTest extends AppTest {
	
	@Autowired
	private  ItemEstoqueRepository itemEstoqueRepository;
	
	Estoque estoque = new Estoque();
	Produto produto = new Produto();
		
	@Before
	public void before() {
		estoque.setId(1l);
		produto.setId(1l);
	}
		
	@Test
	public void deveContarProdutos() {

		Integer total = itemEstoqueRepository.countByEstoqueAndProduto(estoque, produto);		
		assertEquals(total.intValue(), 4);
		
	}
	
}

