package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class WalletBean {

	int i = 0;
	private String name;

	private long mobile;
	private long balance;
	private String password;
	private String tran;
	private long accNo;

	public String getName() {
		return name;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTransaction(String tran) {
		this.tran = tran;
		i++;
	}



	public long getMobile() {
		return mobile;
	}

	public long getAccNo() {
		return accNo;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long bal) {
		this.balance = bal;
	}

	public boolean getPassword(String password) {
		if (this.password.equals(password))
			return true;
		else
			return false;

	}

	public String getPassword1() {
		return password;

	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public 		WalletBean(String name, long accNo, long mobile, String password, long bal, String tan)
			throws SQLException {

		this.name = name;
		
		this.mobile = mobile;
		this.password = password;
		balance = bal;
		tran = tan;
		this.accNo = accNo;
		i++;

	}

	public String getTran() {
		return tran;
	}

	public void setTran(String tran) {
		this.tran = tran;
	}

	public String getPassword() {
		return password;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "CreateAccount [i=" + i + ", name=" + name + ",  mobile=" + mobile
				+ ", balance=" + balance + ", password=" + password + ", tran=" + tran + "]";
	}

	public void setPassword(String password) {
		this.password = password;
	}

}