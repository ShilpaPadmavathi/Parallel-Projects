package com.capg.projectservice;

import java.util.List;
import java.util.Scanner;

import com.capg.daoservice.ProjectDAO;
import com.capg.projectbean.ProjectBean;
import com.capg.projectbean.Transaction;


public class ProjectService implements ProjectServiceI{
	ProjectDAO dao=new ProjectDAO();
	Scanner sc=new Scanner(System.in);

	public ProjectBean project(ProjectBean bean1) {
		// TODO Auto-generated method stub
		ProjectBean mb=dao.project(bean1);
		return mb;
	}

	public ProjectBean showBalance(long acctNo) throws Exception {
		ProjectBean bean=dao.showBalance(acctNo);
		return bean;
		
	}
	public ProjectBean deposit(long acctNo,int bal) throws Exception {
		ProjectBean bean=dao.deposit(acctNo,bal);
		return bean;
		
	}
	public ProjectBean withdraw(long acctNo,int bal1) throws Exception {
		ProjectBean bean=dao.withdraw(acctNo,bal1);
		return bean;
		
	}
	public ProjectBean fundTransfer(long acctNo,long acctNo1,int bal2) throws Exception {
		ProjectBean bean=dao.fundTransfer(acctNo,acctNo1,bal2);
		return bean;
		
	}
	public List<Transaction> getTransactions(long acctNo) throws Exception {
		List<Transaction> l=dao.getTransactions(acctNo);
		return l;
		
}public int validateBalance(int balance) {
	while(true) {
		
		if(balance<=0) {
			System.out.println("Amount is Zero Please Enter Valid Amount");
			balance=sc.nextInt();
		}
		else
			return balance;
	}
	}

public String validateName(String uname) {
		if(!uname.matches("[A-Z][a-zA-Z] * ")) {
			return uname;}
		else {
			System.out.println("Please Enter Name with Capitals");
			uname=sc.next();
			return uname;
	}
}
public String validateMobile(String mobile) {
	if(mobile.length()<10 ) {
		System.out.println("Please Enter A Valid Mobile Number");
		mobile=sc.next();
}
	return mobile;
}}
