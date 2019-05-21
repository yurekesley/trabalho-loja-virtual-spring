package br.com.yurekesley.qualquercoisaapp;

import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
// @AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
@Transactional
public class AppTest {
	
	
	 @Autowired
	 EntityManagerFactory emf;

	 @Bean(name = "transactionManager")
	 public PlatformTransactionManager transactionManager() {
	  JpaTransactionManager tm = new JpaTransactionManager();
	  tm.setEntityManagerFactory(emf);
	  return tm;
	 }
	
	@After()
	public void cleanUp() {}

}
