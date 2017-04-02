/**
 * 
 */
package com.fundit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fundit.beans.FundingBean;
import com.fundit.beans.ProjectBean;
import com.fundit.services.FundService;
import com.fundit.services.ProjectService;

/**
 * @author Kashif
 *
 */
@Controller
public class FundController {
	
	@Autowired
	private FundService fundService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/fund/{projectId}", method = RequestMethod.GET)
	public ModelAndView fundPage(HttpServletRequest request,
			HttpServletResponse response, FundingBean fundingBean, @PathVariable("projectId") int projectId) {
		
		ModelAndView model = new ModelAndView();
		fundingBean.setProject_id(projectId);
		//get proj
		ProjectBean pj= projectService.getProject(projectId);
		
		System.out.println("projectId: "+ projectId);
		request.setAttribute("projectId", projectId);
		request.getSession().setAttribute("projectTitle", pj.getProject_title());
		fundingBean.setProject_id(projectId);
		
		model.setViewName("AddFund");
		model.addObject("fundingBean", fundingBean);
		
		return model;

	}
	
	@RequestMapping(value = "/fund/add", method = RequestMethod.POST)
	public ModelAndView addFund(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("fundingBean") com.fundit.beans.FundingBean fundingBean) {
		
		ModelAndView model = new ModelAndView();
		System.out.println("Fund amount to add: "+ fundingBean.getFund_added());
		System.out.println("projectId: "+ fundingBean.getProject_id());
		System.out.println("UserID: "+ request.getSession().getAttribute("loggedInUser").toString());
		
		fundingBean.setUser_id(request.getSession().getAttribute("loggedInUser").toString());
		
		if(fundService.addFund(fundingBean)){
			request.setAttribute("message", "Successfully added Fund to Proposal...!!!");
			model.setViewName("AddFund");
			model.addObject("fundingBean", fundingBean);
		}else{
			request.setAttribute("message", "Failed in adding fund to proposal, please try again!!!");
			model.setViewName("AddFund");
			model.addObject("fundingBean", fundingBean);
		}
		return model;
	}
}	
