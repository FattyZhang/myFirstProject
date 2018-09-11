package com.example.myFirstProject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public static final String DEFAULT_ERROR_VIEW = "error";
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ModelAndView exceptionHandelByThymeleaf(Exception ex,HttpServletRequest req){
	System.out.println("捕获异常。。。。。。。。:"+ex.getMessage());
	ModelAndView mav=new ModelAndView();
	mav.setViewName(DEFAULT_ERROR_VIEW);
	mav.addObject("exception", ex.getMessage());
	mav.addObject("url", req.getRequestURL());
	return mav;
	}
	
}
