package controllers.administrator;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import services.BulletinBoardService;
import services.RoomService;


import controllers.AbstractController;
import domain.BulletinBoard;
import domain.Room;

@Controller
@RequestMapping("/room/administrator")
public class RoomAdministratorController extends AbstractController{
	@Autowired
	private RoomService bulletinService; 
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView editCreate() {
		ModelAndView result;
		Room b=bulletinService.create();
		result = createEditModelAndView(b);		

		return result;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView saveCreate(@Valid Room c, BindingResult binding) {
		ModelAndView result;
		
			try {
				bulletinService.save(c);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {

				result = createEditModelAndView(c,"bulletin.commit.error");
			}
		

		return result;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView saveDelete(@Valid Room c, BindingResult binding) {
		ModelAndView result;
		
			try {
				bulletinService.delete(c);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {

				result = createEditModelAndView(c,"bulletin.commit.error");
			}
		

		return result;
	}
	protected ModelAndView createEditModelAndView(Room o) {
		ModelAndView result;

		result = createEditModelAndView(o, null);
		
		return result;
	}	
	
	protected ModelAndView createEditModelAndView(Room o, String message) {
		ModelAndView result;
		result = new ModelAndView("room/create");
		result.addObject("room",o);
		result.addObject("message", message);
		return result;
	}
}
