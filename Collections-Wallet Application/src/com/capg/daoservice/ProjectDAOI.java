package com.capg.daoservice;

import java.util.List;

import com.capg.projectbean.ProjectBean;

 interface ProjectDAOI {
	
	 public ProjectBean project(ProjectBean bean1) ;

	//ProjectBean showBalance(String mobile1, String pwd);

	 public ProjectBean showBalance(long acctNo) throws Exception ;
	 public ProjectBean deposit(long acctNo,int bal) throws Exception; 
	 public ProjectBean withdraw(long acctNo,int bal1) throws Exception;
	 public ProjectBean fundTransfer(long acctNo,long acctNo1,int bal2) throws Exception;
	 public List getTransactions(long acctNo) throws Exception;

}
