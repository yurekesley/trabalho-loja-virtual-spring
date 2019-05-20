package br.com.yurekesley.qualquercoisaapp;

import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(SpringRunner.class)
@SpringBootTest()
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
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
