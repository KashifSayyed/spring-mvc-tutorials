/**
 * 
 */
package com.fundit.services;

import java.util.List;

import com.fundit.beans.FundingBean;
import com.fundit.beans.ProjectBean;
import com.fundit.dao.FundDao;
import com.fundit.dao.ProjectDao;

/**
 * @author Kashif
 *
 */
public class FundService {
	private FundDao fundDao;

	
	
	public FundDao getFundDao() {
		return fundDao;
	}

	public void setFundDao(FundDao fundDao) {
		this.fundDao = fundDao;
	}

	public boolean addFund(FundingBean fundingBean){
		return fundDao.addFund(fundingBean);
	}
	
	}
