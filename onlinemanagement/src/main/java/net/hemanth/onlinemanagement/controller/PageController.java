package net.hemanth.onlinemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.hemanth.onlinemanagement.dao.ProductDAO;
import net.hemanth.onlinemanagement.dto.Product;

@Controller
public class PageController {

	@Autowired
	private ProductDAO productDao;

	@RequestMapping(value = { "/", "home", "index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
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
	
	
	@RequestMapping(value = "/addproducts")
	public ModelAndView addProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAddProducts", true);
		mv.addObject("productz", new Product()); 
		return mv;
	}
	
	@RequestMapping(value = { "/viewproducts" })
	public ModelAndView viewProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickViewProducts", true);
		mv.addObject("products", productDao.getProducts());
		return mv;
	}
	
	@RequestMapping(value = "/saveproducts", method = RequestMethod.POST )
	public ModelAndView saveProducts(@ModelAttribute("productz") Product p,BindingResult br) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAddProducts", true);
		productDao.saveProduct(p);
		return mv;
	}


}
