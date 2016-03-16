package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.BulletinBoard;
import domain.Gym;
import domain.Room;

import services.BulletinBoardService;
import services.CustomerService;
import services.GymService;
import services.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController extends AbstractController {

	@Autowired
	private RoomService bulletinService;
	@Autowired
	private CustomerService customerService;


	public RoomController() {
		super();
	}
	// listing
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;
			Collection<Room> b;
			b = bulletinService.findAll();
			
			result = new ModelAndView("room/list");
			result.addObject("rooms", b);
			result.addObject("requestURI", "/room/list.do");
			return result;
		}
		
}