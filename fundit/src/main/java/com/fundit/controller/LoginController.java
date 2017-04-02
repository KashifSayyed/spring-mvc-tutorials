/**
 * 
 */
package com.fundit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fundit.beans.LoginBean;
import com.fundit.beans.ProjectBean;
import com.fundit.beans.UserProfileBean;
import com.fundit.services.LoginService;

/**
 * @author Kashif
 * 
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response, LoginBean loginBean) {
		// model.addAttribute("message", "Spring 3 MVC Hello World");
		// return "Login";
		ModelAndView model = new ModelAndView("Login");
		// LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;

	}

	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("loginBean") com.fundit.beans.LoginBean loginBean) {

		System.out.println("In login method");
		System.out.println("userName= " + loginBean.getUsername());
		ModelAndView model = new ModelAndView();
		
		UserProfileBean userProfileBean = loginService.authenticateUser(loginBean);
		if (userProfileBean != null) {
			request.setAttribute("loggedInUser", loginBean.getUsername());
			request.getSession().setAttribute("userProfileBean", userProfileBean);
			request.getSession().setAttribute("loggedInUser", loginBean.getUsername());
			//System.out.println("JSON ==> "+ JacksonJsonMapper.createEntity(userProfileBean).getBody());
			
			model.setViewName("Home");
			model.addObject("projectBean", new ProjectBean());
		} else {
			request.getSession().removeAttribute("userProfileBean");
			model.setViewName("Login");
			model.addObject("loginBean", loginBean);
		}

		return model;
	}
	
	@RequestMapping(value = "/auth/logoff", method = RequestMethod.GET)
	public ModelAndView logoff(HttpServletRequest request,
			HttpServletResponse response, LoginBean loginBean){
		
		request.getSession().removeAttribute("userProfileBean");
		ModelAndView model = new ModelAndView();
		model.addObject("loginBean", loginBean);
		model.setViewName("Login");
		
		return model;
	}
	
	@RequestMapping(value = "/setupData", method = RequestMethod.GET)
	public ModelAndView setupData(HttpServletRequest request,
			HttpServletResponse response, LoginBean loginBean){
		
		ModelAndView model = new ModelAndView();
		loginService.createTables();
		model.addObject("loginBean", loginBean);
		model.setViewName("Home");
		
		return model;
	}
	
	@RequestMapping(value = "/howItWorks", method = RequestMethod.GET)
	public ModelAndView howItworks(HttpServletRequest request,
			HttpServletResponse response, LoginBean loginBean){		
		ModelAndView model = new ModelAndView();	
		model.addObject("loginBean", loginBean);
		model.setViewName("HowItWorks");
		
		return model;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView gotohome(HttpServletRequest request,
			HttpServletResponse response, LoginBean loginBean){		
		ModelAndView model = new ModelAndView();	
		model.addObject("loginBean", loginBean);
		model.setViewName("Home");
		
		return model;
	}
	
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public ModelAndView aboutus(HttpServletRequest request,
			HttpServletResponse response, LoginBean loginBean){		
		ModelAndView model = new ModelAndView();	
		model.setViewName("Aboutus");
		
		return model;
	}
}
