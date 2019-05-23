package com.yqy.seckill.Service;

import com.yqy.seckill.Service.model.UserModel;

/**
 * @program: seckill-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-22 18:17
 **/
public interface UserService {
    UserModel getUserById(Integer id);
 }
