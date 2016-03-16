package controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.FolderService;
import services.MessageService;

import controllers.AbstractController;
import domain.Actor;
import domain.Folder;
import domain.Message;

@Controller
@RequestMapping("/folder")
public class FolderController extends AbstractController {
	@Autowired
	private ActorService actorService;
	@Autowired
	private FolderService folderService;
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Actor a=actorService.findByPrincipal();
		result = new ModelAndView("folder/list");
		result.addObject("folders", a.getFolders());
		result.addObject("requestURI", "/folder/list.do");
		return result;
	}
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public ModelAndView messages(@RequestParam int folderId) {
		ModelAndView result;
		Folder f=folderService.findOne(folderId);
		result = new ModelAndView("folder/messages");
		result.addObject("messages", f.getMessages());
		result.addObject("requestURI", "/folder/messages.do");
		return result;
	}
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public ModelAndView message(@RequestParam int messageId) {
		ModelAndView result;
		Message m=messageService.findOne(messageId);
		result = new ModelAndView("folder/message");
		result.addObject("message", m);
		return result;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int folderId) {
		ModelAndView result;
		Folder f = folderService.findOne(folderId);
		result = createEditModelAndView(f);
		return result;
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView editCreate() {
		ModelAndView result;
		Actor a = actorService.findByPrincipal();
		Folder f = folderService.create();
		f.setActor(a);
		result = createEditModelAndView(f);

		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView saveCreate(@Valid Folder f, BindingResult binding) {
		ModelAndView result;

		try {
			if (f.getName().equalsIgnoreCase("in box")
					|| f.getName().equalsIgnoreCase("out box")
					|| f.getName().equalsIgnoreCase("spam box")
					|| f.getName().equalsIgnoreCase("trash box")){
				result = createEditModelAndView(f, "folder.commit.error");
			}else{
			folderService.save(f);
			result = new ModelAndView("redirect:/folder/list.do");
			}
		} catch (Throwable oops) {

			result = createEditModelAndView(f, "folder.commit.error");
		}

		return result;
	}

	protected ModelAndView createEditModelAndView(Folder f) {
		ModelAndView result;

		result = createEditModelAndView(f, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Folder f, String message) {
		ModelAndView result;
		result = new ModelAndView("folder/create");
		if (f.getName().equalsIgnoreCase("in box")
				|| f.getName().equalsIgnoreCase("out box")
				|| f.getName().equalsIgnoreCase("spam box")
				|| f.getName().equalsIgnoreCase("trash box")){
			result.addObject("restrict", "si");
		}else{
			result.addObject("restrict", null);
		}
			result.addObject("folder", f);
		result.addObject("message", message);
		return result;
	}
}
