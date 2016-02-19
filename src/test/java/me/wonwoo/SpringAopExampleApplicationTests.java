package me.wonwoo;

import me.wonwoo.model.User;
import me.wonwoo.service.HelloAopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringAopExampleApplication.class)
public class SpringAopExampleApplicationTests {


	@Autowired
	private HelloAopService helloAopService;

	@Test
	public void contextLoads() {
//		helloAopService.getName();
		User user = new User();
		String name = user.getName();
		System.out.println(name);
	}

}
