package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import services.ServiceService;

import domain.Comment;
import domain.Service;

@Controller
@RequestMapping("/service")
public class ServiceController extends AbstractController {
	// Services
	@Autowired
	private ServiceService serviceService;



	public ServiceController() {
		super();
	}

	// listing
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Service> services;
		services = serviceService.findAll();
		result = new ModelAndView("service/list");
		result.addObject("services", services);
		result.addObject("requestURI", "/service/list.do");
		return result;
	}
	
	@RequestMapping(value = "/serviceDetails",method = RequestMethod.GET)
	public ModelAndView serviceDetails(@RequestParam int serviceId){
		ModelAndView result;
		Service service;
		
		service = serviceService.findOne(serviceId);
		Assert.notNull(service);
		result = createEditModelAndView(service);
		
		return result;
	}
	
	
	//ANCILLARY METHODS
	
	protected ModelAndView createCategoryModelAndView(Service service) {
		ModelAndView result;
		
		result = new ModelAndView("service/serviceDetails");
		result.addObject("service", service);
		
		return result;
	}
	
	protected ModelAndView createEditModelAndView(Service service){
		ModelAndView result;
		
		result = createEditModelAndView(service,null);
		
		return result;
	}
	
	protected ModelAndView createEditModelAndView(Service service, String message) {
		ModelAndView result;
		Collection<Comment> comments= service.getComments();
		result = new ModelAndView("service/serviceDetails");
		result.addObject("requestURI","/service/serviceDetails.do");
		result.addObject("service",service);
		result.addObject("comments",comments);
		return result;
	}
	
	
}
