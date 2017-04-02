/**
 * 
 */
package com.fundit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fundit.beans.ProjectBean;
import com.fundit.services.ProjectService;

/**
 * @author Kashif
 *
 */
@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response, ProjectBean projectBean) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("CreateProj");
		model.addObject("projectBean", projectBean);
		return model;

	}
	
	@RequestMapping(value = "/project/add", method = RequestMethod.POST)
	public ModelAndView addProject(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("projectBean") com.fundit.beans.ProjectBean projectBean) {
		
		ModelAndView model = new ModelAndView();
		System.out.println("Title: "+ projectBean.getProject_title());
		projectBean.setUser_id(request.getSession().getAttribute("loggedInUser").toString());
		
		if(projectService.addProject(projectBean)){
			request.setAttribute("message", "Successfully added proposal...!!!");
			model.setViewName("CreateProj");
			model.addObject("projectBean", projectBean);
		}else{
			request.setAttribute("message", "Failed in adding project, please try again!!!");
			model.setViewName("CreateProj");
			model.addObject("projectBean", projectBean);
		}
		return model;
	}
	
	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public ModelAndView getProject(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("projectId") int projectId){
		
		System.out.println("projectId: "+ projectId);
		ProjectBean projectBean = projectService.getProject(projectId);
		//ProjectBean projectBean = getProject(); //projectService.getAllProject();
		request.setAttribute("projectBean", projectBean);
		System.out.println("Project Title: "+ projectBean.getProject_title());

		ModelAndView model = new ModelAndView("ProjectDetails");
		model.addObject(projectBean);
		
		return model;
	}
	
	@RequestMapping(value = "/project/all", method = RequestMethod.GET)
	public ModelAndView getAllProject(HttpServletRequest request,
			HttpServletResponse response){

		List<ProjectBean> projectBeans = projectService.getAllProject();
		//List<ProjectBean> projectBeans = getProjects(); //
		request.setAttribute("projectBeans", projectBeans);
		
		ModelAndView model = new ModelAndView("Explore");
		model.addObject("projectBeans",projectBeans);
		
		return model;
	}
	
	private ProjectBean getProject(){
		ProjectBean projectBean = new ProjectBean();
		projectBean.setProject_id(1);
		projectBean.setProject_title("test");
		projectBean.setProject_description("test");
		projectBean.setProject_purpose("test");
		projectBean.setProject_global_business("test");
		projectBean.setProject_planned_finish_date("test");
		projectBean.setProject_fund_required(10000);
		projectBean.setProject_fund_received(5000);
		projectBean.setUser_id("test");
		
		return projectBean;
	}
	
	private List<ProjectBean> getProjects(){
		List<ProjectBean> projectBeans = new ArrayList<ProjectBean>();
		ProjectBean projectBean = new ProjectBean();
		projectBean.setProject_id(1);
		projectBean.setProject_title("test");
		projectBean.setProject_description("test");
		projectBean.setProject_purpose("test");
		projectBean.setProject_global_business("test");
		projectBean.setProject_planned_finish_date("test");
		projectBean.setProject_fund_required(10000);
		projectBean.setProject_fund_received(5000);
		projectBean.setUser_id("test");
		
		projectBeans.add(projectBean);
		
		projectBean = new ProjectBean();
		projectBean.setProject_id(2);
		projectBean.setProject_title("asd");
		projectBean.setProject_description("asd");
		projectBean.setProject_purpose("asd");
		projectBean.setProject_global_business("asd");
		projectBean.setProject_planned_finish_date("asd");
		projectBean.setProject_fund_required(10000);
		projectBean.setProject_fund_received(5000);
		projectBean.setUser_id("asd");
		
		projectBeans.add(projectBean);
		return projectBeans;
	}
	/*@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public HttpEntity<ProjectBean> getProject(@PathVariable("projectId") int projectId){
		
		System.out.println("projectId: "+ projectId);
		ProjectBean projectBean = projectService.getProject(projectId);
		System.out.println("Project Title: "+ projectBean.getProject_title());
		
		HttpEntity<ProjectBean> entity = JacksonJsonMapper.createEntity(projectBean);
		System.out.println("JSON ==> "+ entity);
		//ModelAndView model = new ModelAndView();
		return entity;
	}
	
	@RequestMapping(value = "/project/all", method = RequestMethod.GET)
	public HttpEntity<List<ProjectBean>> getAllProject(HttpServletRequest request,
			HttpServletResponse response){

		List<ProjectBean> projectBeans = projectService.getAllProject();
		HttpEntity<List<ProjectBean>> entity = JacksonJsonMapper.createEntity(projectBeans);
		System.out.println("JSON ==> "+ entity);
		return entity;
	}*/
	

}	
