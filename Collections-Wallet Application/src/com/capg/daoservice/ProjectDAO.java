package com.capg.daoservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.capg.projectbean.ProjectBean;
import com.capg.projectbean.Transaction;

public class ProjectDAO implements ProjectDAOI {
	ProjectBean pb;
	HashMap<Long, ProjectBean> hx = null;
	HashMap<Transaction, Long> hx1=null;

	public ProjectDAO() {
		hx = new HashMap<Long, ProjectBean>();
		hx1 = new HashMap<Transaction, Long>();
	}

	@Override
	public ProjectBean project(ProjectBean bean1) {
		hx.put(bean1.getAcctNo(), bean1);
		ProjectBean mb1 = (ProjectBean) hx.get(bean1.getAcctNo());
		return mb1;
	}

	@Override
	public ProjectBean showBalance(long acctNo) throws Exception {
		pb = (ProjectBean) hx.get(acctNo);
		if(pb==null) {
			throw new AccountNotFoundException("Please Enter A Valid Account Number");
		}
		else
			return pb;
	}

	@Override
	public ProjectBean deposit(long acctNo, int bal) throws Exception {
		pb = (ProjectBean) hx.get(acctNo);
		if(pb==null) {
			throw new AccountNotFoundException("Please Enter A Valid Account Number");
		}
		float s = pb.getBalance();
		float s1 = s + bal;
		pb.setBalance(s1);
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		Random r = new Random();
		int transId = r.nextInt(20000);
		Transaction t = new Transaction();
		t.setTransId(transId);
		t.setTransDate(strDate);
		t.setBalance(s1);
		t.setTransType("deposit");
		hx1.put(t, acctNo);
		return pb;
	}

	public ProjectBean withdraw(long acctNo, int bal1) throws Exception {
		// TODO Auto-generated method stub
		ProjectBean pb1 = (ProjectBean) hx.get(acctNo);
		if(pb1==null) {
			throw new AccountNotFoundException("Please Enter A Valid Account Number");
		}
		else {
		float s = pb1.getBalance();
		if(s<=bal1) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}
		float s2 = s - bal1;
		pb1.setBalance(s2);

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		Random r = new Random();
		int transId = r.nextInt(20000);
		Transaction t = new Transaction();
		t.setTransId(transId);
		t.setTransDate(strDate);
		t.setBalance(s2);
		t.setTransType("withdraw");
		hx1.put(t, acctNo);
		return pb1;
	}}

	public ProjectBean fundTransfer(long acctNo, long acctNo1, int bal2) throws Exception {
		// hx.put(bean, bal2);
		ProjectBean pb1 = (ProjectBean) hx.get(acctNo);
		if(pb1==null) {
			throw new Exception("Please Enter A Valid Account Number");
		}
		else {
			if(pb1.getBalance()<=bal2) {
		ProjectBean pb2 = (ProjectBean) hx.get(acctNo1);
		float s = pb1.getBalance();
		float s1 = s - bal2;
		float s3 = s + bal2;
		pb1.setBalance(s1);
		pb2.setBalance(s3);

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		Random r = new Random();
		int transId = r.nextInt(20000);
		Transaction t = new Transaction();
		t.setTransId(transId);
		t.setTransDate(strDate);
		t.setBalance(s1);
		t.setTransType("transfer");
		t.setAccFrom(acctNo);
		t.setAccTo(acctNo1);
		hx1.put(t, acctNo);
	}
			return pb1;}}
	public List<Transaction> getTransactions(long acctNo) throws Exception {
		ProjectBean pb1 = (ProjectBean) hx.get(acctNo);
		if(pb1==null) {
			throw new Exception("Please Enter A Valid Account Number");
		}
		else {
		ArrayList<Transaction> al = new ArrayList<Transaction>(hx1.keySet());
		return al;
	}}
}
