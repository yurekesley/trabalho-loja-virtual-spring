package br.com.yurekesley.qualquercoisaapp;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = true)
public class AppConfiguration {

	 @Autowired
	 EntityManagerFactory emf;

	 @Bean(name = "transactionManager")
	 public PlatformTransactionManager transactionManager() {
	  JpaTransactionManager tm = new JpaTransactionManager();
	  tm.setEntityManagerFactory(emf);
	  return tm;
	 }
	
}