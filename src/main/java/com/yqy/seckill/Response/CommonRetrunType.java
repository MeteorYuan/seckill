package com.yqy.seckill.Response;

/**
 * @program: seckill-springboot
 * @description:规范化前端返回数据
 * @author: Mr.Yqy
 * @create: 2019-05-23 11:51
 **/
public class CommonRetrunType {
    //表明对应请求的返回结果，有success和fail
    private String status;
    //若status=success，data返回前端需要的数据，否则data内使用通用的错误码格式
    private Object data;


    //请求正常时使用此调用方法，result为返回参数
    public static CommonRetrunType create(Object result){
        return CommonRetrunType.create("success",result);
    }

    //请求异常时使用次方法，返回状态和错误信息
    public static CommonRetrunType create(String status,Object o){
        CommonRetrunType ct=new CommonRetrunType();
        ct.setStatus(status);
        ct.setData(o);
        return ct;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
