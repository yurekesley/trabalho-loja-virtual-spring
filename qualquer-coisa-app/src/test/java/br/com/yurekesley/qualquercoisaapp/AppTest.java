package br.com.yurekesley.qualquercoisaapp;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AppTest {
	
	@After()
	public void cleanUp() {}

}
