package net.hemanth.onlinemanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	/*
	 * This will handle the 404 Error
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "OUCH! 404 ");
		mv.addObject("errorDescription", "Sorry the page you are looking for does not exist.Contact Hemanth!");
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	/*
	 * This will handle the product modification while editing it . Used in PageController
	 * For eg: in URL if we give id of product which is not in DB 
	 */
	@ExceptionHandler(ProductException.class)
	public ModelAndView handlerProductException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product not correct!");
		mv.addObject("errorDescription", "The product you are editing is not available right now!");
		mv.addObject("title", "Product Unavailable");
		
		return mv;
	}
	
	/*
	 * This will handle the product modification while editing it . Used in PageController.
	 * For eg: in URL if we give letters instead of number 
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact Hemanth !!");
		mv.addObject("errorDescription", ex);
		mv.addObject("title", "Error");
		
		return mv;
	}
}	
