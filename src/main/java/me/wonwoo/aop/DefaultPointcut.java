package me.wonwoo.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
public class DefaultPointcut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
        return (clazz) -> true;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new AnnotationMethodMatcher(AopAnnotation.class);
    }
}
