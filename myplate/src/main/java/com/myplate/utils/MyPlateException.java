package com.myplate.utils;

/**
 * Description:
 * Program Name:
 * author :john
 * Date:2018-10-2018/10/13  15:38  星期六
 * version 1.0
 */
public class MyPlateException extends  Exception{
    //错误消息
    private String msg;
    //是否异步
    private boolean async;


    public MyPlateException(){
        super();
    }

    public MyPlateException(String msg) {
        super(msg);
        this.async = false;
        this.msg = msg;
    }

    public MyPlateException(Exception e){
        if(e instanceof MyPlateException){
            MyPlateException self = (MyPlateException) e;
            this.msg = self.getMsg();
        }else{
            this.msg = e.getMessage();
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

}
