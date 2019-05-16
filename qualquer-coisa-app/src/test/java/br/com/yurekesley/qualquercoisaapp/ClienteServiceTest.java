package br.com.yurekesley.qualquercoisaapp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.yurekesley.qualquercoisaapp.model.Cliente;
import br.com.yurekesley.qualquercoisaapp.service.ClienteService;

public class ClienteServiceTest extends AppTest {
	
	@Autowired
	private ClienteService clienteService;
	private Cliente cliente = null;
	
	@Before
	public void before() {
		cliente = new Cliente();
		cliente.setId(5l);
		cliente.setNome("YURE KESLEY");
	}
	
	@Test
	public void deveSalvarCliente() {
		cliente.setId(5l);
		cliente.setNome("YURE KESLEY");
		this.clienteService.save(cliente);
		
		Cliente find = this.clienteService.findById(cliente.getId());
		
		assertEquals(find.getId(), cliente.getId());
	}
		
}
