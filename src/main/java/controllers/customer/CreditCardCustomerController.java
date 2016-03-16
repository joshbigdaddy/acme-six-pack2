package controllers.customer;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import services.CustomerService;


import controllers.AbstractController;
import domain.Customer;

@Controller
@RequestMapping("/creditcard/customer")
public class CreditCardCustomerController extends AbstractController{
	@Autowired
	private CustomerService customerService; 
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView editCreate(@RequestParam int customerId) {
		ModelAndView result;
		Customer o=customerService.findOne(customerId);
		result = createEditModelAndView(o);		

		return result;
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView saveCreate(@Valid Customer c, BindingResult binding) {
		ModelAndView result;
		
			try {
				customerService.save(c);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {

				result = createEditModelAndView(c,"creditcard.commit.error");
			}
		

		return result;
	}
	protected ModelAndView createEditModelAndView(Customer o) {
		ModelAndView result;

		result = createEditModelAndView(o, null);
		
		return result;
	}	
	
	protected ModelAndView createEditModelAndView(Customer o, String message) {
		ModelAndView result;
		result = new ModelAndView("creditcard/create");
		result.addObject("customer",o);
		result.addObject("message", message);
		return result;
	}
}
