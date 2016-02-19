# spring-aop-example

### @Around 

프록시를 통해서 타겟 오브젝트의 메소드가 호출되는 전 과장을 모두 담을 수 있는 어드바이스다. 

```
    @Around("helloPointCut()")
    public Object helloAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("Around");
        logger.info("전처리");
        Object ret = pjp.proceed();
        logger.info("후처리");
        return ret;
    }
```

### @Before 

이름 그대로 오브젝트의 메소드가 실행 되기 전에 사용되는 어드바이스다.

```
    @Before("helloPointCut()")
    public void logJoinPoint(JoinPoint jp) {
        logger.info("Before");
        logger.info(jp.getSignature().getDeclaringTypeName());
        logger.info(jp.getSignature().getName());
        for(Object arg : jp.getArgs()) {
            logger.info(arg + "");
        }
    }
```


### @AfterReturning

메소드가 실행을 마친뒤 실행되는 메소드다. 단 예외가 발생하지 않고 정상적으로 실행 되었을때에만 해당된다.
해당 메소드에서 리턴 값을 참조 할수있으나 값을 변경할 수는 없다. 하지만 리턴값이 레퍼런스 타입이라면 오브젝트를 조작할 수는 있다.
```
