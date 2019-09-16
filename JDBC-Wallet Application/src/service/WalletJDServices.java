package service;

import java.sql.SQLException;

import bean.WalletBean;
import dao.WalletJDDao;

class MyException extends Exception {
	String s1;

	MyException(String s) {
		s1 = s;

	}

	public String toString() {
		return (s1);
	}

}

public class WalletJDServices implements WalletJDServicesI {
	WalletJDDao bd = new WalletJDDao();

	@Override
	public boolean checkName(String name) {
		int n = name.length();
		char[] ch = name.toCharArray();
		for (int i = 0; i < n; i++) {
			try {
				if (ch[i] > 64 && ch[i] < 122 && ch[0]>63 && ch[0]<90) {
					return true;
				} else {
					throw new MyException("Invalid Name");
				}
			} catch (MyException E) {
				System.out.println(E);
				return false;
			}

		}
		return false;

	}

	@Override
	public long getBalance(long accNo) throws ClassNotFoundException, SQLException {
		long acc = bd.getBalance(accNo);
		return acc;

	}

	@Override
	public String getTransaction(long accNo) throws ClassNotFoundException, SQLException {
		String str = bd.getTransaction(accNo);
		return str;

	}

	@Override
	public void setBalance(long accNo, long bal, String st) throws ClassNotFoundException, SQLException {
		bd.setBalance(accNo, bal, st);

	}

	@Override
	public String addAccount(String name, long mobile,  String password)
			throws SQLException, ClassNotFoundException {
		long accNo = mobile - 10000;
		if (bd.checkMobile(mobile)) {
			WalletBean bb = new WalletBean(name, accNo, mobile, password, 1000, "Account Created Successfully\n Amount deposited Rs.1000");
			bd.setData(bb);
			return " Account Created Successfully \n Your Account number is " + accNo;
		} else
			return " Account already created ";
	}
	@Override
	public boolean checkAccNo(long acc) throws ClassNotFoundException, SQLException {
		try {
			if (bd.checkAccNo(acc)) {

				return true;
			}

			else
				throw new MyException("Wrong Account Number");
		} catch (MyException E) {
			System.out.println(E);
		}
		return false;
	}

	@Override
	public boolean checkPass(String st) throws ClassNotFoundException, SQLException {
		try {
			if (bd.checkPassword(st)) {

				return true;
			} else
				throw new MyException("Wrong Password");
		} catch (MyException E) {
			System.out.println(E);
		}
		return false;
	}

	@Override
	public boolean checkM(long mob) {
		// TODO Auto-generated method stub
		String s = Long.toString(mob);
		int n = s.length();
		try {
			if (n == 10) {
				return true;
			} else {
				throw new MyException("Invalid Number");
			}
		} catch (MyException E) {
			System.out.println(E);
			return false;
		}

	}

	@Override
	public boolean checkP(String password) {
		// TODO Auto-generated method stub
		try {
			if (password.length() >= 6) {
				return true;
			} else {
				throw new MyException("Invalid Password \n Enter more than six characters");
			}
		} catch (MyException E) {
			System.out.println(E);
			return false;
		}

	}
	@Override
	public WalletBean getInfo(long accNo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		WalletBean b=bd.getInfo(accNo);
		return b;
	}
}