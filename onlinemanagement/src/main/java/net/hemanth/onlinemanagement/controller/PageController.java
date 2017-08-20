package net.hemanth.onlinemanagement.controller;

import java.util.Optional;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.hemanth.onlinemanagement.dao.ProductDAO;
import net.hemanth.onlinemanagement.dto.Product;
import net.hemanth.onlinemanagement.exception.ProductException;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private ProductDAO productDao;

	@RequestMapping(value = { "/", "home", "index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = {"/addproducts", "/addproducts/{id}"})
	public ModelAndView addProducts(@PathVariable Optional<Integer> id) throws ProductException{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Products");
		mv.addObject("userClickAddProducts", true);
		if (!id.isPresent()) {
			mv.addObject("productz", new Product());
		} else {
			Integer i=id.get();
			mv.addObject("edit",true);
			/* when viewing products and clicking edit , the url will contain that id, if we modify that id in url , http://localhost:9091/onlinemanagement/addproducts/11
			if its not there in db null will be returned and custom exception page is displayed*/  
			if(productDao.getProductByid(i)==null)
				throw new ProductException();
			mv.addObject("productz", productDao.getProductByid(i));
		}
		return mv;
	}

	@RequestMapping(value = { "/viewproducts" })
	public ModelAndView viewProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "View Products");
		mv.addObject("userClickViewProducts", true);
		mv.addObject("products", productDao.getProducts());
		return mv;
	}

	@RequestMapping(value = "/saveproducts", method = RequestMethod.POST)
	public String saveProducts(@Valid @ModelAttribute("productz") Product p, BindingResult br,Model m) {
		
		if(br.hasErrors()) {
			// if errors are there display the same page
			m.addAttribute("title", "Add Products");
			m.addAttribute("userClickAddProducts", true);
			return "page";
		}

		// save the product data 
		productDao.saveProduct(p);
		
		// if no error display the view products page
		m.addAttribute("title", "View Products");
		m.addAttribute("userClickViewProducts", true);
		return "redirect:/viewproducts";
	}
	
	@RequestMapping(value = "/deleteproduct/{id}")
	public ModelAndView deleteProduct(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "View Products");
		mv.addObject("userClickViewProducts", true);
		productDao.deleteProductByid(id);
		mv.addObject("products", productDao.getProducts());
		return mv;
	}

	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Sorry ! Access Denied");		
		mv.addObject("errorDescription", "You are not authorized to view this page! Ask hemanth to make u ADMIN ");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}
}
