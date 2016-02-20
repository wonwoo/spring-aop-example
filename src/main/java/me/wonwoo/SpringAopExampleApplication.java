package me.wonwoo;

import me.wonwoo.aop.DefaultPointcut;
import me.wonwoo.aop.MethodInterceptorExample1;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
public class SpringAopExampleApplication {


	@Bean
	public PointcutAdvisor potincutAdviser() {
		DefaultBeanFactoryPointcutAdvisor advisor = new DefaultBeanFactoryPointcutAdvisor();
		advisor.setPointcut(new DefaultPointcut());
		advisor.setAdvice(new MethodInterceptorExample1());
		return advisor;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringAopExampleApplication.class, args);
	}

}
