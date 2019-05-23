package com.yqy.seckill.Controller;

import com.yqy.seckill.Controller.ViewObject.UserVO;
import com.yqy.seckill.Error.BusinessException;
import com.yqy.seckill.Error.EmBusinessError;
import com.yqy.seckill.Response.CommonRetrunType;
import com.yqy.seckill.Service.UserService;
import com.yqy.seckill.Service.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.plugin.com.event.COMEventHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @program: seckill-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-22 18:15
 **/
@RestController
@RequestMapping("/user")
public class UserController extends  BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping("get")
    public CommonRetrunType getUser(@RequestParam(name="id")Integer id) throws BusinessException {
       //将核心领域模型转化为供ui使用的视图模型
        UserModel userModel= userService.getUserById(id);

        //若用户获取的对应信息不存在
        if(userModel==null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        UserVO userVO= convertFromModel(userModel);
        return CommonRetrunType.create(userVO);
    }


    private UserVO convertFromModel(UserModel userModel){
        if(userModel==null){
            return null;
        }else
        {
            UserVO userVo=new UserVO();
            BeanUtils.copyProperties(userModel,userVo);
            return userVo;
        }
    }



}
