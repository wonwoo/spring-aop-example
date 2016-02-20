package me.wonwoo.component;

import me.wonwoo.aop.AopAnnotation;
import org.springframework.stereotype.Component;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
@Component
public class HelloComponent {

    @AopAnnotation
    public String getComponent(){
        String hello = "hello";
        System.out.println(hello);
        return hello + " wonwoo";
    }

    public String getComponent1(){
        String hello = "hello";
        System.out.println(hello);
        return hello + " wonwoo1";
    }
}
