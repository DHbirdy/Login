package com.ceair.controller;

import lombok.Data;

/**
 * @author lvpeng
 * @description 处理异常
 * 先创建JsonResult类响应结果类型，
 * 并在其中声明需要它可以给客户的数据的属性：
 * @date 2020/10/9-15:10
 */


/*
    在编写控制器中处理请求的代码时，就不必再关注异常的问题，等同于控制器中处理请求时将异常抛出，
 */
    @Data
public class JsonResult<V> {
    private Integer state;
    private  String message;


}
