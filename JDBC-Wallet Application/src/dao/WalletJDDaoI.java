package dao;
import java.sql.SQLException;

import bean.WalletBean;

public interface WalletJDDaoI {
	
	long getBalance(long accNo) throws ClassNotFoundException, SQLException;

	void setBalance(long accNo, long bal, String st) throws ClassNotFoundException, SQLException;

	boolean checkMobile(long mob) throws ClassNotFoundException, SQLException;

	boolean checkPassword(String str) throws ClassNotFoundException, SQLException;

	boolean checkAccNo(long accNo) throws ClassNotFoundException, SQLException;

	void setData(WalletBean bb) throws ClassNotFoundException, SQLException;

	String getTransaction(long accNo) throws SQLException, ClassNotFoundException;

	WalletBean getInfo(long accNo) throws ClassNotFoundException, SQLException;
}