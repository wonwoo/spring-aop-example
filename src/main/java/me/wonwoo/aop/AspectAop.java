package me.wonwoo.aop;

import me.wonwoo.exception.UserException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wonwoo on 2016. 2. 19..
 */
@Component
@Aspect
public class AspectAop {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Pointcut("execution(* me..*Service.*(..))")
    private void helloPointCut(){
    }

    @Before("helloPointCut()")
    public void logJoinPoint(JoinPoint jp) {
        logger.info("Before");
        logger.info(jp.getSignature().getDeclaringTypeName());
        logger.info(jp.getSignature().getName());
        for(Object arg : jp.getArgs()) {
            logger.info(arg + "");
        }
    }

    @Around("helloPointCut()")
    public Object helloAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("Around");
        logger.info("전처리");
        Object ret = pjp.proceed();
        logger.info("후처리");
        return ret;
    }

    @AfterReturning(pointcut="helloPointCut()", returning="name")
    public void logReturnValue(String name) {
        logger.info("AfterReturning");
        logger.info(name);
    }

    @AfterThrowing(pointcut = "helloPointCut()", throwing = "e")
    public void logThrowValue(UserException e){
        logger.info("exception");
        logger.info(e.getId());
    }

    @After("helloPointCut()")
    public void logAfterValue(JoinPoint jp) {
        logger.info("after");
        logger.info(jp.getSignature().getDeclaringTypeName());
        logger.info(jp.getSignature().getName());
        for(Object arg : jp.getArgs()) {
            logger.info(arg + "");
        }
    }
}
