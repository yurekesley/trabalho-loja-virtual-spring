package br.com.yurekesley.qualquercoisaapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.yurekesley.qualquercoisaapp.service.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest("application.test.properties")
@TestPropertySource(locations = "classpath:application.test.properties")
@SqlGroup({
    @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
    @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql") })
public class QualquerCoisaAppApplicationTests {

	@Autowired
	private ClienteService clienteService;

	@Test
	public void contextLoads() {

		clienteService.findAll();

	}

}
