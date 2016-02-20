package me.wonwoo.aop;

import java.lang.annotation.*;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopAnnotation {
}
