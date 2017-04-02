package com.mybank.onlinebank.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mybank.onlinebank.beans.LoginBean;
import com.mybank.onlinebank.beans.UserProfileBean;
import com.mybank.onlinebank.service.LoginService;


/**
 * @author Kashif
 * 
 */
@Controller
public class LoginController {
	
	@Resource
	private LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response, LoginBean loginBean) {
		ModelAndView model = new ModelAndView("Login");
		model.addObject("loginBean", loginBean);
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean) {

		System.out.println("In login method");
		System.out.println("userName= " + loginBean.getUsername());
		ModelAndView model = new ModelAndView();
		
		UserProfileBean userProfileBean = loginService.authenticateUser(loginBean);
		if (userProfileBean != null) {
			request.setAttribute("loggedInUser", loginBean.getUsername());
			request.getSession().setAttribute("userProfileBean", userProfileBean);
			request.getSession().setAttribute("loggedInUser", loginBean.getUsername());
			
			model.setViewName("Home");
		} else {
			request.getSession().removeAttribute("userProfileBean");
			model.setViewName("Login");
			model.addObject("loginBean", loginBean);
		}

		return model;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoff(HttpServletRequest request,
			HttpServletResponse response, LoginBean loginBean){
		
		request.getSession().removeAttribute("userProfileBean");
		ModelAndView model = new ModelAndView();
		model.addObject("loginBean", loginBean);
		model.setViewName("Login");
		
		return model;
	}

}
