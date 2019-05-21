package br.com.yurekesley.qualquercoisaapp.repository;

import static org.junit.Assert.assertNotEquals;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class RepositoryTest {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private EntityManager entityManager;

	@Test
	public void injectedComponentsAreNotNull() {

		assertNotEquals(dataSource, null);
		assertNotEquals(entityManager, null);

	}

}
