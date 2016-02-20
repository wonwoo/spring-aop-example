package me.wonwoo;

import me.wonwoo.component.HelloComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringAopExampleApplication.class)
public class MethodInterceptorTest1 {

    @Autowired
    private HelloComponent helloComponent;

    @Test
    public void method(){
        System.out.println(helloComponent.getComponent());
        System.out.println(helloComponent.getComponent1());
    }
}
