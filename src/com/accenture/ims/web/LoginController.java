package com.accenture.ims.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.ims.business.bean.LoginBean;

import com.accenture.ims.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/loadlogin", method = RequestMethod.GET)
	public ModelAndView loadlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		mv.addObject("login", new LoginBean());
		return mv;

	}

	@RequestMapping(value = "/validatelogin", method = RequestMethod.POST)
	public ModelAndView validatelogin(@Valid @ModelAttribute("login") LoginBean loginBean,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();

		if (loginService.validateLogin(loginBean.getUserName())) {
			mv.setViewName("Dashboard");
			mv.addObject("login", new LoginBean());
			return mv;
		} else {
			mv.setViewName("Login");
			mv.addObject("login", new LoginBean());
			return mv;
		}
	}

}
