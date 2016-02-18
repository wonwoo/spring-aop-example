package me.wonwoo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wonwoo on 2016. 2. 19..
 */
@Component
@Aspect
public class AspectAop {


    @Pointcut("execution(* me..*Service.*(..))")
    private void helloPointCut(){
    }

    @Before("helloPointCut()")
    public void logJoinPoint(JoinPoint jp) {
        System.out.println("Before");
        System.out.println(
                jp.getSignature().getDeclaringTypeName()
        );
        System.out.println(
                jp.getSignature().getName()
        );
        for(Object arg : jp.getArgs()) {
            System.out.println(arg);
        }
    }

    @Around("helloPointCut()")
    public Object helloAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around");
        System.out.println("전처리");
        Object ret = pjp.proceed();
        System.out.println("후처리");
        return ret;
    }

    @AfterReturning(pointcut="helloPointCut()", returning="name")
    public void logReturnValue(String name) {
        System.out.println("AfterReturning");
        System.out.println(name);
    }
}
