package me.wonwoo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
public class MethodInterceptorExample1 implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("method interceptor start");
        Object returnValue=methodInvocation.proceed();
        System.out.println("method interceptor end");
        return returnValue;
    }
}
