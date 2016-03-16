package controllers.actor;





import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import security.Authority;
import security.UserAccount;
import security.UserAccountService;
import services.CustomerService;
import controllers.AbstractController;
import domain.Customer;

@Controller
@RequestMapping("/userAccount/actor")
public class UserAccountActorController extends AbstractController {
	
	// Services ---------------------------------------------------------------

	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private CustomerService customerService;
	// Constructors -----------------------------------------------------------
	
	public UserAccountActorController() {
		super();
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		
		Customer customer;
		customer=customerService.create();
		ModelAndView result;

		result = createEditModelAndView(customer);

		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
public ModelAndView save(@Valid Customer customer, BindingResult res) {
	ModelAndView result;
	
	try{
	
		UserAccount userAccount= customer.getUserAccount();
		
		Authority authority= new Authority();
		authority.setAuthority(Authority.CUSTOMER);
		userAccount.addAuthority(authority);
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String password=encoder.encodePassword(userAccount.getPassword(), null);
		userAccount.setPassword(password);
		
		
		userAccountService.save(userAccount);
		userAccount=userAccountService.findAll().get(userAccountService.findAll().size()-1);
		customer.setUserAccount(userAccount);
		
		
		customerService.save(customer);
		result = new ModelAndView("redirect:/welcome/index.do");
		
	}catch(Throwable oops){
		result = createEditModelAndView(customer,"customer.commit.error");
		result.addObject("userName", customer.getUserAccount().getUsername());
		result.addObject("name", customer.getName());
		result.addObject("surname", customer.getSurname());
		
	}
	
	return result;	
	
	}
		

	// Ancillary methods ------------------------------------------------------
	
			protected ModelAndView createEditModelAndView(Customer customer) {
				ModelAndView result;

				result = createEditModelAndView(customer,null);
				
				return result;
			}	
			
			protected ModelAndView createEditModelAndView( Customer customer,String message) {
				ModelAndView result;
				
				result = new ModelAndView("userAccount/create");
				result.addObject("customer",customer);
				result.addObject("message", message);

				return result;
			}
}
