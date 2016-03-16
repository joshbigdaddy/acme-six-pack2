package controllers.customer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;

import services.CustomerService;
import services.SocialIdentityService;
import domain.Customer;
import domain.SocialIdentity;

@Controller
@RequestMapping("/socialIdentity/customer")
public class SocialIdentityCustomerController extends AbstractController {
	// Services ------------------------------------------------------------
	@Autowired
	private SocialIdentityService socialIdentityService;

	@Autowired
	private CustomerService customerService;

	// Constructors -----------------------------------------------------------

	public SocialIdentityCustomerController() {
		super();
	}

	// Create SocialIdentity

	// @RequestMapping(value = "/create", method = RequestMethod.GET)
	// public ModelAndView createSocialIdentity(){
	// SocialIdentity socialIdentity;
	// ModelAndView result;
	//
	// socialIdentity = socialIdentityService.create();
	// result = createSocialIdentityModelAndView(socialIdentity);
	//
	// return result;
	// }
	// Showing SocialIdentity

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewSocialIdentity() {
		ModelAndView result;
		Customer customer;
		customer = customerService.findByPrincipal();
		SocialIdentity socialIdentity;
		result = new ModelAndView("socialIdentity/view");

		if (customer.getSocialIdentity() == null) {

			socialIdentity = socialIdentityService.create();

		} else {

			socialIdentity = customer.getSocialIdentity();

		}

		result.addObject("socialIdentity", socialIdentity);
		result.addObject("requestURI", "socialIdentity/customer/view.do");

		return result;

	}
	
	
	@RequestMapping(value = "/view", method = RequestMethod.POST, params = "create")
	public ModelAndView create(@Valid SocialIdentity socialIdentity,
			BindingResult binding) {
		ModelAndView result;
		if (binding.hasErrors()) {
			result = createEditModelAndView(socialIdentity);
		} else {
			try {
				socialIdentityService.save(socialIdentity);
				socialIdentity = socialIdentityService.findAll().get(
						socialIdentityService.findAll().size() - 1);
				Customer customer = customerService.findByPrincipal();
				customer.setSocialIdentity(socialIdentity);
				customerService.save(customer);
				result = new ModelAndView("redirect:view.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(socialIdentity,
						"socialIdentity.commit.error");
			}
		}
		return result;
	}

	// EDITION METHODS

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int socialIdentityId) {
		ModelAndView result;
		SocialIdentity socialIdentity;

		socialIdentity = socialIdentityService.findOne(socialIdentityId);
		Assert.notNull(socialIdentity);
		result = createEditModelAndView(socialIdentity);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid SocialIdentity socialIdentity,
			BindingResult binding) {
		ModelAndView result;
		if (binding.hasErrors()) {
			result = createEditModelAndView(socialIdentity);
		} else {
			try {
				//socialIdentityService.save(socialIdentity);
				//socialIdentity = socialIdentityService.findAll().get(
					//	socialIdentityService.findAll().size() - 1);
				Customer customer = customerService.findByPrincipal();
				customer.setSocialIdentity(socialIdentity);
				customerService.save(customer);
				socialIdentityService.save(customer.getSocialIdentity());
				result = new ModelAndView("redirect:view.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(socialIdentity,
						"socialIdentity.commit.error");
			}
		}
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(SocialIdentity socialIdentity,
			BindingResult binding) {
		ModelAndView result;

		try {
			socialIdentityService.delete(socialIdentity);
			Customer customer=customerService.findByPrincipal();
			customer.setSocialIdentity(null);
			customerService.save(customer);
			result = new ModelAndView("redirect:view.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(socialIdentity,
					"categry.commit.error");
		}
		return result;
	}

	// ANCILLARY METHODS

	protected ModelAndView createSocialIdentityModelAndView(
			SocialIdentity socialIdentity) {
		ModelAndView result;

		result = new ModelAndView("socialIdentity/view");
		result.addObject("socialIdentity", socialIdentity);

		return result;
	}

	protected ModelAndView createEditModelAndView(SocialIdentity socialIdentity) {
		ModelAndView result;

		result = createEditModelAndView(socialIdentity, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(
			SocialIdentity socialIdentity, String message) {
		ModelAndView result;

		result = new ModelAndView("socialIdentity/edit");
		result.addObject("requestURI", "/socialIdentity/customer/edit.do");
		result.addObject("socialIdentity", socialIdentity);

		return result;
	}
}
