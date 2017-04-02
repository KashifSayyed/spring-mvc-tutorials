package com.fundit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fundit.beans.ProjectBean;
import com.fundit.services.ProjectService;



@Controller
public class DashBoardController{
	
	@Autowired
	private ProjectService projectService;
	
	String loginName = "";
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response, ProjectBean projectBean) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard");
		loginName = request.getSession().getAttribute("loggedInUser").toString();

		return model;

	}
	
	@RequestMapping(value = "/dashboard/piechart", method = RequestMethod.GET)
	public void drawPieChart(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("image/png");
		PieDataset pdSet = getAllProjectFundStatusForPieChart();

		JFreeChart chart = createPieChart(pdSet, "Proposals Funding Status");
		
		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart,
					750, 400);
			response.getOutputStream().close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/dashboard/barchart", method = RequestMethod.GET)
	public void drawBarChart(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("image/png");
		
		JFreeChart chart = createBarChart();

		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart,
					750, 400);
			response.getOutputStream().close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private DefaultPieDataset createDataSet() {
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("Fully Funded", 21);
		dpd.setValue("Funding crossed Half Mark", 30);
		dpd.setValue("Funding in Initial Stages", 49);
		return dpd;
	}

	private JFreeChart createPieChart(PieDataset pdSet, String chartTitle) {
		JFreeChart chart = ChartFactory.createPieChart3D(chartTitle, pdSet,
				true, true, false);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;
	}
	
	private JFreeChart createBarChart(){
		JFreeChart chart = ChartFactory.createBarChart("My Projects","","", getAllProjectFundStatusForBarChart(),PlotOrientation.VERTICAL, true, true, false);
		return chart;
	}
	
	private DefaultCategoryDataset createBarDataset()
	   {
	      final String proposal1 = "proposal1";        
	      final String proposal2 = "proposal2";        
	      final String proposal3 = "proposal3";        
	      final String TotalFunds = "TotalFunds";        
	      final String myFunds = "myFunds";        
	      final String Contribution = "Contribution";
	      final String BalanceRequired = "Balance Required";
	      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

	      dataset.addValue( 100, TotalFunds, proposal1);        
	      dataset.addValue( 35, myFunds, proposal1);        
	      dataset.addValue( 65, Contribution, proposal1);
	      dataset.addValue( 0, BalanceRequired, proposal1);

	      dataset.addValue( 100, TotalFunds, proposal2);        
	      dataset.addValue( 45, myFunds, proposal2);        
	      dataset.addValue( 55, Contribution, proposal2);
	      dataset.addValue( 0, BalanceRequired, proposal2);
	      
	      dataset.addValue( 100, TotalFunds, proposal3);        
	      dataset.addValue( 30, myFunds, proposal3);        
	      dataset.addValue( 20, Contribution, proposal3);
	      dataset.addValue( 50, BalanceRequired, proposal3);
	      
	      return dataset; 
	   }
	
	//for preparing Bar Chart
	private DefaultCategoryDataset getAllProjectFundStatusForBarChart(){
		List<ProjectBean> projectBeanList = new ArrayList<ProjectBean>();
		
		/*if(null != projectdao.getDataSource()){
			projectBeanList = projectdao.getAllProject();
		}*/
		projectBeanList  = projectService.getAllProject();
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		if(null != projectBeanList && projectBeanList.size() > 0){
			int fundsContributed = 0;
			int totalFunds = 0;
			int myFunds = 0;
			int balanceRequired = 0;
			for(ProjectBean projectBean : projectBeanList){
				if(loginName.equalsIgnoreCase(projectBean.getUser_id())){
					totalFunds = projectBean.getProject_fund_required();
					myFunds = projectBean.getProject_my_fund();
					fundsContributed = projectBean.getProject_fund_received() - myFunds;
					balanceRequired = totalFunds - myFunds - fundsContributed;
					dataSet.addValue(totalFunds, "TotalFunds", projectBean.getProject_title());        
					dataSet.addValue(myFunds, "myFunds", projectBean.getProject_title());
				    dataSet.addValue(fundsContributed, "Contribution", projectBean.getProject_title());
				    dataSet.addValue(balanceRequired, "balanceRequired", projectBean.getProject_title());
				    fundsContributed = 0;
					totalFunds = 0;
					myFunds = 0;
					balanceRequired = 0;
				}
			}
		}else{
			dataSet = createBarDataset();
		}
		return dataSet;
	}
	
	
	// for preparing pie chart
	private DefaultPieDataset getAllProjectFundStatusForPieChart(){
		
		List<ProjectBean> projectBeanList = new ArrayList<ProjectBean>();
		
		/*if(null != projectdao.getDataSource()){
			projectBeanList = projectdao.getAllProject();
		}*/
		projectBeanList = projectService.getAllProject();
		DefaultPieDataset dpd = new DefaultPieDataset();
		Map<String, Integer> pieChartMap = new HashMap<String, Integer>();
		if(null != projectBeanList && projectBeanList.size() > 0){
			int totalProjects = projectBeanList.size();
			int fullyFunded = 0;
			int fundingStarted = 0;
			int halfFundingReceived = 0;
			for(ProjectBean projectBean : projectBeanList){
				if(projectBean.getProject_fund_required() <= projectBean.getProject_fund_received()){
					fullyFunded++;
					pieChartMap.put("Fully Funded", fullyFunded);
				}else if(projectBean.getProject_fund_received() >= projectBean.getProject_fund_required()/2){
					halfFundingReceived++;
					pieChartMap.put("Funding crossed Half Mark", halfFundingReceived);
				}else if(projectBean.getProject_fund_received() <= projectBean.getProject_fund_required()/2){
					fundingStarted++;
					pieChartMap.put("Funding in Initial Stages", fundingStarted);
				}
			}
			
			if(pieChartMap.size() > 0){
				for(Map.Entry<String, Integer> entry : pieChartMap.entrySet()){
					String key = entry.getKey();
					int value = (entry.getValue()*100)/totalProjects;
					dpd.setValue(key, value);
				}
			}
		}else{
			dpd = createDataSet();
		}
		return dpd;
	}

}
