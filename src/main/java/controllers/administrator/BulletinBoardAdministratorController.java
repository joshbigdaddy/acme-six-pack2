package controllers.administrator;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import services.BulletinBoardService;


import controllers.AbstractController;
import domain.BulletinBoard;

@Controller
@RequestMapping("/bulletin/administrator")
public class BulletinBoardAdministratorController extends AbstractController{
	@Autowired
	private BulletinBoardService bulletinService; 
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView editCreate() {
		ModelAndView result;
		BulletinBoard b=bulletinService.create();
		result = createEditModelAndView(b);		

		return result;
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView saveCreate(@Valid BulletinBoard c, BindingResult binding) {
		ModelAndView result;
		
			try {
				bulletinService.save(c);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {

				result = createEditModelAndView(c,"bulletin.commit.error");
			}
		

		return result;
	}
	protected ModelAndView createEditModelAndView(BulletinBoard o) {
		ModelAndView result;

		result = createEditModelAndView(o, null);
		
		return result;
	}	
	
	protected ModelAndView createEditModelAndView(BulletinBoard o, String message) {
		ModelAndView result;
		result = new ModelAndView("bulletin/create");
		result.addObject("bulletinBoard",o);
		result.addObject("message", message);
		return result;
	}
}
