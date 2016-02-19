package me.wonwoo.exception;

/**
 * Created by wonwoo on 2016. 2. 19..
 */
public class UserException extends RuntimeException{

    private String id;

    public UserException(String id) {
        this.id = id;
    }
    public String getId(){
        return id;
    }
}
