package service;

import java.sql.SQLException;

import beans.BankBean;
import beans.CustomerAddress;
import daomap.BankDao;
import daomap.BankDao1;

class MyException extends Exception {
	String s1;

	MyException(String s) {
		s1 = s;

	}

	public String toString() {
		return (s1);
	}

}

public class BankService implements BankService1 {
	BankDao1 bd = new BankDao();

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
	public long getBalance(long accNo) {
		long acc = bd.getBalance(accNo);
		return acc;

	}

	@Override
	public String getTransaction(long accNo) {
		String str = bd.getTransaction(accNo);
		return str;

	}

	@Override
	public void setBalance(long accNo, long bal, String st)  {
		bd.setBalance(accNo, bal, st);

	}

	@Override
	public String addAccount(String name, long mobile,  String password)
			 {
			BankBean bb = new BankBean(name, mobile, password, 1000, "Account Created Successfully\n Amount deposited Rs.1000");
			long accNo=bd.setData(bb);
			return " Account Created Successfully \n Your Account number is " + accNo;
			 }

	@Override
	public boolean checkAccount(long acc) {
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
	public boolean checkPass(String st,long accNo) {
		try {
			if (bd.checkPassword(st,accNo)) {

				return true;
			} else
				throw new MyException("Wrong Password");
		} catch (MyException E) {
			System.out.println(E);
		}
		return false;
	}

	@Override
	public boolean checkMobile(long mobile) {
		// TODO Auto-generated method stub
		String s = Long.toString(mobile);
		int i = s.length();
		try {
			if (i == 10) {
				return true;
			} else {
				throw new MyException("Please Enter a Valid Mobile Number");
			}
		} catch (MyException E) {
			System.out.println(E);
			return false;
		}

	}

	@Override
	public boolean checkPassword(String password) {
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
}
