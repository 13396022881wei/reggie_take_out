package com.atheima.reggie.common;

/**
 * FileName:     BaseContext
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-10
 * Description :基于ThreadLocal封装的工具类，用于保存和获取当前登录用户的id
 */
public class BaseContext {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();


    public  static void setCurrentId(Long id){
        threadLocal.set(id);
    }


    public static Long getCurrentId(){
        return threadLocal.get();
    }




}
