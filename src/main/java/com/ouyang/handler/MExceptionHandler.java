package com.ouyang.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MExceptionHandler{
	
	//@ResponseBody
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception e){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg",e.getMessage());
		return new ModelAndView("exception", map);
	}

}
