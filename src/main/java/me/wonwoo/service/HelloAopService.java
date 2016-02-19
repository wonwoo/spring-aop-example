package me.wonwoo.service;

import me.wonwoo.exception.UserException;
import org.springframework.stereotype.Component;

/**
 * Created by wonwoo on 2016. 2. 19..
 */
@Component
public class HelloAopService {

    public String name(){
        return "hello";
    }

    public String getName(){
//        if(true){
//            throw new UserException("wonwoo");
//        }
        return "wonwoo";
    }
}
