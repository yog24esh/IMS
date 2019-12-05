package com.accenture.ims.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DummyController {

	@RequestMapping("/test.html")
	public ModelAndView loadPage(){
		return new ModelAndView("dummy");
	}
}
