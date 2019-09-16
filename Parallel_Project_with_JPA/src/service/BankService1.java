package service;

import java.sql.SQLException;

import beans.BankBean;
import beans.CustomerAddress;

public interface BankService1 {

	long getBalance(long accNo);

	String getTransaction(long accNo);

	void setBalance(long accNo, long bal, String st) ;

	
	boolean checkAccount(long acc) ;

	boolean checkPass(String st,long accNo);

	boolean checkName(String name);

	boolean checkPassword(String password);

	String addAccount(String name, long mobile, String password) ;

	boolean checkMobile(long mobile);

}
