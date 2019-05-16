package br.com.yurekesley.qualquercoisaapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.yurekesley.qualquercoisaapp.model.Cliente;
import br.com.yurekesley.qualquercoisaapp.service.ClienteService;

public class ClienteServiceTest extends AppTest {
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void deveSalvarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("YURE KESLEY");
		this.clienteService.save(cliente);
	}
	
	@Test
	public void deveRecuperarCliente() {
		Cliente cliente = this.clienteService.findById(1l);		
		assertEquals(1l, cliente.getId().longValue());
	}
}
