package com.yqy.seckill.Service.impl;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import com.yqy.seckill.Service.UserService;
import com.yqy.seckill.Service.model.UserModel;
import com.yqy.seckill.dao.UserDoMapper;
import com.yqy.seckill.dao.UserPasswordDoMapper;
import com.yqy.seckill.dataobject.UserDo;
import com.yqy.seckill.dataobject.UserPasswordDo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;

/**
 * @program: seckill-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-22 18:18
 **/
@Service
public class UserServiceImpl implements UserService {
    /**
     *  在实际生产环境中用户密码单独存储
     */
    @Autowired
    UserDoMapper userDoMapper;
    @Autowired
    UserPasswordDoMapper userPasswordDoMapper;
    @Override
    public UserModel getUserById(Integer id) {
        UserDo userDo=userDoMapper.selectByPrimaryKey(id);
        if(userDo==null){
            return null;
        }
        UserPasswordDo userPasswordDo=userPasswordDoMapper.selectByUserId(userDo.getId());
        return convertFromUserDataObject(userDo,userPasswordDo);
    }

    //创建model和dataobjcet的映射
     private UserModel convertFromUserDataObject(UserDo userDo, UserPasswordDo passwordDo){
         UserModel userModel=new UserModel();
        if(userDo==null||passwordDo==null) {
         return null;
        }
        if(userDo!=null){
            BeanUtils.copyProperties(userDo,userModel);
            userModel.setEncrptPassword(passwordDo.getEncrptPassword());
        }
         return userModel;
     }
}
