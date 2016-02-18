package me.wonwoo.model;

import me.wonwoo.service.HelloAopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Created by wonwoo on 2016. 2. 19..
 */
@Configurable(preConstruction = true)
public class User {


    private HelloAopService helloAopService;

    @Autowired
    public void setHelloAopService(HelloAopService helloAopService){
        this.helloAopService = helloAopService;
    }

    public String getName(){
        return helloAopService.getName();
    }

}
