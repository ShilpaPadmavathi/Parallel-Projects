package com.capg.projectservice;

import java.util.List;

import com.capg.projectbean.ProjectBean;
import com.capg.projectui.ProjectUi;

public interface ProjectServiceI {
	
	public ProjectBean project(ProjectBean bean1) ;
	public ProjectBean showBalance(long acctNo) throws Exception;
	public ProjectBean deposit(long acctNo,int bal) throws Exception ;
	public ProjectBean withdraw(long acctNo,int bal1) throws Exception;
	public ProjectBean fundTransfer(long acctNo,long acctNo1,int bal2) throws Exception;
	public List getTransactions(long acctNo) throws Exception;
}
