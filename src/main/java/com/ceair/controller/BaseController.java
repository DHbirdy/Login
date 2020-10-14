package com.ceair.controller;

import com.ceair.service.PasswordNotException;
import com.ceair.service.ServiceException;
import com.ceair.service.UsernameDuplicateException;
import com.ceair.service.UsernameNotFoundException;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/9-15:58
 */
public class BaseController {
    /**
     * 返回成功状态码2000
     */
    public static final Integer SUCCESS=2000;

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable ex) {

        JsonResult<Void> jsonResult=new JsonResult<>();

        if(ex instanceof UsernameDuplicateException){
            //用户名被占用  -  2002
            jsonResult.setState(2002);
        }else if(ex instanceof UsernameNotFoundException){
            //用户名找不到  -  2003
            jsonResult.setState(2003);
        }else if(ex instanceof PasswordNotException){
            //密码错误
            jsonResult.setState(2004);
        }
        //返回响应值
        return jsonResult;
    }
}
