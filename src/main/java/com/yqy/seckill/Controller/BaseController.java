package com.yqy.seckill.Controller;

import com.yqy.seckill.Error.BusinessException;
import com.yqy.seckill.Error.EmBusinessError;
import com.yqy.seckill.Response.CommonRetrunType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: seckill-springboot
 * @description: Controller基类
 * @author: Mr.Yqy
 * @create: 2019-05-23 14:17
 **/
public class BaseController {
    //定义exceptionhandler解决未被Controller层吸收的异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String,Object> message=new HashMap<>();
        if(ex instanceof BusinessException){
            BusinessException be=(BusinessException)ex;
            message.put("errCode",be.getErrorCode());
            message.put("errMsg",be.getErrMsg());
        }else {
            message.put("errCode",EmBusinessError.UNKNOW_ERROR.getErrorCode());
            message.put("errMsg",EmBusinessError.UNKNOW_ERROR.getErrMsg());
        }

        return CommonRetrunType.create("fail",message);
    }
}
