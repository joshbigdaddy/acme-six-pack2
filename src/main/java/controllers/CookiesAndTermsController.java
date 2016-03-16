package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/legal")
public class CookiesAndTermsController extends AbstractController{
	// Constructors -----------------------------------------------------------
	
		public CookiesAndTermsController() {
			super();
		}
			
		// Action-1 ---------------------------------------------------------------		

		@RequestMapping("/terms")
		public ModelAndView terms() {
			ModelAndView result;
					
			result = new ModelAndView("legal/terms");
			
			return result;
		}
		
		// Action-2 ---------------------------------------------------------------
		
		@RequestMapping("/cookies")
		public ModelAndView cookies() {
			ModelAndView result;
					
			result = new ModelAndView("legal/cookies");
			
			return result;
		}
		
	}

