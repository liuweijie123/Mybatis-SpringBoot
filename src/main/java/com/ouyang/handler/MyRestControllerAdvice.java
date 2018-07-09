package com.ouyang.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ouyang.exception.AuthorizationException;
import com.ouyang.exception.BusinessException;
import com.ouyang.exception.DataAccessException;


@RestControllerAdvice
public class MyRestControllerAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(MyRestControllerAdvice.class);
	
	@ExceptionHandler(RuntimeException.class)
	public Rjson handleRuntimeException(RuntimeException e){
		// http请求异常
        if (e instanceof HttpMessageConversionException){
            log.error("【Bad Request】",e.getMessage(),e);
            return Rjson.error("Bad Request");
        }
        if (e instanceof AuthorizationException){
            log.error("【无操作权限Shiro】",e.getMessage(),e);
            return Rjson.error(Rjson.CODE_1403,"未授权：操作失败，请联系管理员授权");
        }
        if (e instanceof BusinessException){
            log.error("【业务异常】",e.getMessage(),e);
            return Rjson.error(e.getMessage());
        }
        if (e instanceof DataAccessException){
            log.error("【数据库异常：spring-dao】",e.getMessage(),e);
            return Rjson.error("DB异常，请联系管理员");
        }
        log.error("【其他RuntimeException】",e.getMessage(),e);
        return Rjson.error();
	}
	
	/** 全局异常捕捉处理 */
    @ExceptionHandler(Exception.class)
    public Rjson handleException(Exception e){
        if (e instanceof  HttpRequestMethodNotSupportedException){
            return Rjson.error("不支持的请求方式/"+e.getMessage());
        }
        log.error("【未知异常】："+e.getMessage(), e);
        return Rjson.error();
    }
}
