# spring-aop-example


## 어드바이스

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
    @AfterReturning(pointcut="helloPointCut()", returning="name")
    public void logReturnValue(String name) {
        logger.info("AfterReturning");
        logger.info(name);
    }
```

### @AfterThrowing

메소드에서 예외가 발생하면 실행되는 메소드다. 속성중 **throwing**를 이용하여 예외를 전달 받을 수 있다.**throwing** 으로 지정한 타입이 발생 하였을경우에만 실행된다.


```
    @AfterThrowing(pointcut = "helloPointCut()", throwing = "e")
    public void logThrowValue(UserException e){
        logger.info("exception");
        logger.info(e.getId());
    }
```

### @After

메소드가 정상적일 때와 예외가 발생하였을 때도 모두 실행된다. **finally**와 비슷하다고 생각하면 된다.

```
    @After("helloPointCut()")
    public void logAfterValue(JoinPoint jp) {
        logger.info("after");
        logger.info(jp.getSignature().getDeclaringTypeName());
        logger.info(jp.getSignature().getName());
        for(Object arg : jp.getArgs()) {
            logger.info(arg + "");
        }
    }
```

## @Configurable

User 도메인이 있다고 가정해보자. 그 도메인은 일반 ORM이나 MVC에서 쓰는 도메인이다.
만약 그 도메인에 비즈니스 로직이 들어 간다면 DI를 받아야 될 것이다.

```
public class User {

    @Autowired
    private HelloAopService helloAopService;

    public String getName(){
        return helloAopService.getName();
    }
}
```

그런데 User는 빈으로 등록되어 사용되는게 아니다.
일반적으로 도메인은 이렇게 사용한다.

```
User user = new User();
```

이렇게 하면 당연히 **helloAopService**의 값은 **null**으로 getName을 호출시 **NullPointerException** 발생한다.

간단한 방법으로 **@Configurable**을 사용하면 된다.

```
@Configurable(preConstruction = true)
public class User {

    @Autowired
    private HelloAopService helloAopService;

    public String getName(){
        return helloAopService.getName();
    }

}
```



