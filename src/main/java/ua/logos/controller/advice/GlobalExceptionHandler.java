package ua.logos.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import ua.logos.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final String ERROR_VIEW = "error";
	
	//@ExceptionHandler(value = UserNotFoundException.class)
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e){
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("url", req.getRequestURL());
		mav.addObject("httpMethod", req.getMethod());
		mav.addObject("exception", e );
		mav.setViewName(ERROR_VIEW);
		
		return mav;
	}
	
}
