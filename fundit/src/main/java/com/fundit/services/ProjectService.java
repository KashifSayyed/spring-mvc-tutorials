/**
 * 
 */
package com.fundit.services;

import java.util.List;

import com.fundit.beans.ProjectBean;
import com.fundit.dao.ProjectDao;

/**
 * @author Kashif
 *
 */
public class ProjectService {
	private ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}
	
	public boolean addProject(ProjectBean projectBean){
		return projectDao.addProject(projectBean);
	}
	
	public ProjectBean getProject(int projectId){
		return projectDao.getProject(projectId);
	}
	
	public List<ProjectBean> getAllProject(){
		return projectDao.getAllProject();
	}
}
