package com.ouyang.handler;

import java.io.Serializable;

public class Rjson implements Serializable{

	private static final long serialVersionUID = 8072821828319666892L;
	
	/**
     * ajax响应编码，200 表示正常请求，不存在非授权或者未登录请求
     */
    public static final int CODE_DEF = 200;

    /**
     * 未登录，前端判断后，跳转到登录页面
     */
    public static final int CODE_1100 = 1100;

    /**
     * 无权访问
     */
    public static final int CODE_1403 = 1403;

    private Integer code = CODE_DEF;

    private Boolean success = false;

    private String msg;

    private Object obj;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static Rjson error(){
        Rjson r = new Rjson();
        r.setMsg("系统异常，请稍后重试");
        return r;
    }
    
    public static Rjson error(String msg){
        Rjson r = new Rjson();
        r.setMsg(msg == null ? "系统异常，请稍后重试" : msg);
        return r;
    }
    
    public static Rjson error(int code,String msg){
        Rjson r = new Rjson();
        r.setCode(code);
        r.setMsg(msg == null ? "系统异常，请稍后重试" : msg);
        return r;
    }
    
    public static Rjson ok() {
        Rjson r = new Rjson();
        r.setSuccess(true);
        return r;
    }
    
    public static Rjson ok(String msg) {
        Rjson r = new Rjson();
        r.setSuccess(true);
        r.setMsg(msg);
        return r;
    }
    
    public static Rjson ok(Object obj) {
        Rjson r = new Rjson();
        r.setSuccess(true);
        r.setObj(obj);
        return r;
    }
    
    public static Rjson ok(Object obj,String msg) {
        Rjson r = new Rjson();
        r.setSuccess(true);
        r.setObj(obj);
        r.setMsg(msg);
        return r;
    }

}
