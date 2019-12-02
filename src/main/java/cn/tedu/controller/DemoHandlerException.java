package cn.tedu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//@ControllerAdvice表示当前项目的
//                 所有的异常都可以处理
@ControllerAdvice
public class DemoHandlerException {
	//@ExceptionHandler表示处理异常的方法
	@ExceptionHandler
	public String handlerException(
			HttpServletRequest req,
			Exception e){
		req.setAttribute("error",
				e.getMessage());
		return "error";
		
	}

}
