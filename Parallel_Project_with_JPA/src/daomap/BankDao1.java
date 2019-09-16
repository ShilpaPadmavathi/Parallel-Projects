package daomap;

import java.sql.SQLException;

import beans.BankBean;

public interface BankDao1 {
	
	long getBalance(long accNo) ;

	void setBalance(long accNo, long bal, String st);


	boolean checkPassword(String str,long accNo) ;

	boolean checkAccNo(long accNo);

	long setData(BankBean bb);

	String getTransaction(long accNo);
}
