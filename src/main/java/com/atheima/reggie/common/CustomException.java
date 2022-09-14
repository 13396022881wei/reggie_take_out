package com.atheima.reggie.common;

/**
 * FileName:     CustomException
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-10
 * Description :自定义业务异常
 */
public class CustomException extends  RuntimeException  {

    public CustomException(String message){
        super(message);
    }

}

