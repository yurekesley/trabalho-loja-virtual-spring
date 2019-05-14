package br.com.yurekesley.qualquercoisaapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.yurekesley.qualquercoisaapp.service.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QualquerCoisaAppApplicationTests {

	@Autowired
	private ClienteService clienteService;

	@Test
	public void contextLoads() {

		clienteService.findAll();

	}

}
