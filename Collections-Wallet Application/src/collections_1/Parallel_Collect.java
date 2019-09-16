package collections_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
class Test{
	 String accname;	
	 String pwd;
	 double balance;
	public Test(String accname, String pwd,double balance) {
		this.accname = accname;
		this.pwd = pwd;
		this.balance=balance;
	}
	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+accname+""+pwd+""+balance;
	}
}
public class Parallel_Collect{
	public static void main(String[] args) {	
	String phone;
    String accname;
    String pwd;
    double balance=0.0;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter phone");
	phone=sc.next();
	System.out.println("Enter Your Name");
	accname=sc.next();
	System.out.println("Enter Your Password");
	pwd=sc.next();
	HashMap hx=new HashMap();
	Test t=new Test(accname,pwd,balance);
	Test t1=new Test("Jyothi","Jyothi123",30000);
	hx.put(phone,t);
	hx.put("9500378946",t1);
	//System.out.println(hx);
	System.out.println("1.Create Account");
	System.out.println("2.Show Balance");
	System.out.println("3.Deposit");
	System.out.println("4.Withdraw");
	System.out.println("5.Fund Transfer");
	System.out.println("6.Print Transactions");
	System.out.println("Enter Your Option");
	int d=sc.nextInt();
	switch(d) {
	case 1: String phone11=sc.next(); 
	Test t12=(Test) hx.get(phone11);
	System.out.println("Account Created");
	System.out.println(t12+" ");
	break;
	case 2: String phone1=sc.next();
	Test t2=(Test) hx.get(phone1);	
	double s=t2.getBalance();
	System.out.println(s);
	break;
	case 3: int bal=sc.nextInt();
	String num2=sc.next();
	Test t0=(Test) hx.get(num2);
	double c=t0.getBalance();
	double d1=bal+c;
	System.out.println(c);
	break;
	case 4:System.out.println("Enter withdraw amount");
	int bal1=sc.nextInt();
	System.out.println("Enter Phone");
	String num3=sc.next();
	Test t4=(Test) hx.get(num3);
	double c1=t4.getBalance();
	//double d2=c1-bal1;
	//System.out.println(d2);
	if(c1<=0)
		System.out.println("Insufficient Funds");
	else {
		double d2=c1-bal1;
		System.out.println(d2);
	}
	break;
	case 5:System.out.println("Enter Amount For Fund Transfer");
	int bal2=sc.nextInt();
	System.out.println("Enter Phone");
	String num4=sc.next();
	Test t5=(Test) hx.get(num4);
	double c2=t5.getBalance();
	System.out.println("Enter Receivers Phone number");
	String num5=sc.next();
	Test t6=(Test) hx.get(num5);
	double c3=t6.getBalance();
	c2=c2-bal2;
	c3=c3+bal2;
	System.out.println(c2);
	System.out.println(c3);
	break;
	case 6:System.out.println("Print Transactions");
	System.out.println("Enter your Mobile Number");
	String p=sc.next();
	Test t7=(Test) hx.get(p);
	System.out.println(t7);
	break;
	default:System.out.println("Enter valid option");
	System.out.println("THANK UUUUU");
	}
	}
}