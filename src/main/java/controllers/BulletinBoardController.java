package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.BulletinBoard;
import domain.Gym;

import services.BulletinBoardService;
import services.CustomerService;
import services.GymService;

@Controller
@RequestMapping("/bulletin")
public class BulletinBoardController extends AbstractController {

	@Autowired
	private BulletinBoardService bulletinService;
	@Autowired
	private CustomerService customerService;


	public BulletinBoardController() {
		super();
	}
	// listing
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;
			Collection<BulletinBoard> b;
			b = bulletinService.findAll();
			
			result = new ModelAndView("bulletin/list");
			result.addObject("bulletins", b);
			result.addObject("requestURI", "/bulletin/list.do");
			return result;
		}
		
		@RequestMapping(value = "/search", method = RequestMethod.POST, params="search")
		public ModelAndView search(String searchText) {
			Collection<BulletinBoard> allFound = bulletinService.findBySearch(searchText);
			ModelAndView mav = new ModelAndView("bulletin/search");
			mav.addObject("bulletins", allFound);
			mav.addObject("requestURI", "/bulletins/search.do");
			return mav;
		}
}