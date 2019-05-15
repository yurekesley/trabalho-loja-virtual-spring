package br.com.yurekesley.qualquercoisaapp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.yurekesley.qualquercoisaapp.service.ClienteService;

public class QualquerCoisaAppApplicationTests extends AppTest {

	@Autowired
	private ClienteService clienteService;

	@Test
	public void contextLoads() {

		clienteService.findAll();

	}
	
	
	@Test
	public void contextLoads2() {

		clienteService.findAll();

	}

}
