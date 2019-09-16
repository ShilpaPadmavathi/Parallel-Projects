package com.capg.projectui;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import com.capg.daoservice.AccountNotFoundException;
import com.capg.daoservice.InsufficientBalanceException;
import com.capg.projectbean.ProjectBean;
import com.capg.projectbean.Transaction;
import com.capg.projectservice.ProjectService;

public class ProjectUi {
    static ProjectService service=new ProjectService();
    static ProjectBean pb=new ProjectBean();
	public static void main(String[] args) throws Exception {	
		String mobile;
		String uname;
	    String password;
	    long acctNo=0;
	    float balance=20000;

	    while(true) {
	    System.out.println("1.Create Account");
		System.out.println("2.Show Balance");
		System.out.println("3.Deposit");
		System.out.println("4.Withdraw");
		System.out.println("5.Fund Transfer");
		System.out.println("6.Print Transactions");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice");
		int d=sc.nextInt();
		
		switch(d) {
		case 1: 
		System.out.println("Enter Your Username");
		uname=service.validateName(sc.next());
		System.out.println("Enter Your Password");
		password=sc.next();
		System.out.println("Enter Your Mobile Number");
		mobile=service.validateMobile(sc.next());
		Random r=new Random();
		acctNo=r.nextInt(20000);
		ProjectBean bean1=new ProjectBean(uname, password, balance,mobile,acctNo);
		ProjectBean bean =service.project(bean1);
		System.out.println("ACCOUNT CREATED WELCOME");
		System.out.println("The Account Number is"+bean.getAcctNo());
		
		break;
		
		case 2:System.out.println("Enter Your Account Number");
		acctNo=sc.nextLong(); 
		try {

			ProjectBean bean3 =service.showBalance(acctNo);
			System.out.println("Available Balance"+bean3.getBalance());
			
		}
		catch(AccountNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		break;
		
		case 3:
			try {
				System.out.println("Enter Your Account Number");
				acctNo=sc.nextLong();
				System.out.println("Enter the balance to transfer");
				int bal=service.validateBalance(sc.nextInt());
				ProjectBean bean4 =service.deposit(acctNo,bal);
				System.out.println("Available Balance After Deposit is"+bean4.getBalance());
			}
			catch(AccountNotFoundException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		break;
		
		case 4:System.out.println("Enter Your Account Number");
		acctNo=sc.nextLong();
		try {
			System.out.println("Enter the balance to withdraw");
			int bal1=service.validateBalance(sc.nextInt());
			ProjectBean bean5 =service.withdraw(acctNo,bal1);
			System.out.println(bean5.getBalance());
		}
		catch(AccountNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);}
			catch(InsufficientBalanceException e) {
				System.out.println("Available Balance After Withdraw is:"+e.getMessage());
				System.exit(0);
			}
		break;
		
		case 5:System.out.println("Enter Your Account Number");
		acctNo=sc.nextLong();
		try {
			System.out.println("Enter Account Number of receiver");
			long acctNo1=sc.nextLong();
			System.out.println("Enter the balance to transfer");
			int bal2=service.validateBalance(sc.nextInt());
			ProjectBean bean6 =service.fundTransfer(acctNo,acctNo1,bal2);
			System.out.println(bean6.getBalance());
			System.out.println("Successfully Transfered fund");
			
		}
		catch(AccountNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		break;
		
		case 6:System.out.println("Enter Your Account Number");
		acctNo=sc.nextLong();
		try {
			List<Transaction> l=service.getTransactions(acctNo);
			System.out.println("Your Transactions Are"+l+'\n');
		}
		catch(Exception e) {
			System.out.println("Invalid Account Number");
			System.exit(0);
		}
		
		break;
		
		case 7: System.exit(0);
		break;
		
		default: System.out.println("Please Enter Valid Choice");
		System.out.println("THANK UUUUU");
		sc.close();
		
		}	
}}}
