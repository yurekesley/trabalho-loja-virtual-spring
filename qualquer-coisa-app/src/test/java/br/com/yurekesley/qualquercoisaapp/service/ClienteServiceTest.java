package br.com.yurekesley.qualquercoisaapp.service;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.yurekesley.qualquercoisaapp.AppTest;
import br.com.yurekesley.qualquercoisaapp.model.Cliente;

public class ClienteServiceTest extends AppTest {
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void deveSalvarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("NETO DOIDO");
		clienteService.save(cliente);
		
		Cliente find = this.clienteService.buscarPorNome("NETO DOIDO");
		assertNotEquals(find.getId(),null);
	}
		
}
