package ui;

import java.sql.SQLException;
import java.util.Scanner;

import bean.WalletBean;
import service.WalletJDServices;

public class WalletJDUI {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		WalletJDServices bs = new WalletJDServices();
		while (true) {
			System.out.println("****************************************************************");

			System.out.println("                         Pay Wallet");
			System.out.println("****************************************************************");
			System.out.println();

			System.out.println(
					" 1. Create Account \n 2. Show Balance \n 3. Deposit \n 4. Withdraw \n 5. Fund Transfer \n 6. Print Transaction \n 7. Print Info \n 8. Exit \n \n*************************************************************** \n");
				System.out.println("Enter Your Choice : ");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter your name : ");
				String name = sc.next();
				name += sc.nextLine();
				if (!bs.checkName(name)) {
					break;
				}
				System.out.println("Enter your mobile number : ");
				long mob = sc.nextLong();
				if (!bs.checkM(mob)) {
					break;
				}
				System.out.println("Enter a password :");
				String password = sc.next();
				if (!bs.checkP(password)) {
					break;
				}
				String st = bs.addAccount(name, mob,  password);
				System.out.println(st);

				break;
			case 2:
				System.out.println(" Enter Your Account number");
				long accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.println("Enter your Password");
					String pass = sc.next();
					if (bs.checkPass(pass)) {
						long bal = bs.getBalance(accNo);
						System.out.println("your account balance is " + bal);
					}
				}

				break;
			case 3:
				System.out.println(" Enter Your Account number");
				accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.println("Enter your Password");
					String pass = sc.next();
					if (bs.checkPass(pass)) {
						long bal = bs.getBalance(accNo);

						System.out.println("Enter the amount to be deposited");
						long bal1 = sc.nextInt();
						if(bal1>0) {
						bs.setBalance(accNo, bal + bal1, " \n Amount credited Rs." + bal1);
						System.out.println("Amount You deposited is " + bal1);
						System.out.println("Total balance is " + bs.getBalance(accNo));
						}
						else {
							System.out.println("Enter Balance Greater than zero");
						}
					}
				}
				break;
			case 4:
				System.out.println(" Enter Your Account number");
				accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.println("Enter your Password");
					String pass = sc.next();
					if (bs.checkPass(pass)) {
						long bal = bs.getBalance(accNo);
						System.out.println("Enter the amount to be withdrawn");
						long bal1 = sc.nextInt();
						bs.setBalance(accNo, bal - bal1, " \n Amount debited Rs." + bal1);
						System.out.println("Amount You withdraw is " + bal1);
						System.out.println("Total balance is " + bs.getBalance(accNo));

					}
				}
				break;
			case 5:
				System.out.println(" Enter Your Account number");
				accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.println("Enter your Password");
					String pass = sc.next();
					if (bs.checkPass(pass)) {
						System.out.println(" Enter Account number where you want to transer fund");
						long accNo1 = sc.nextLong();
						if (bs.checkAccNo(accNo1)) {
							long bal = bs.getBalance(accNo);
							long bal1 = bs.getBalance(accNo1);

							System.out.println("Enter the amount to be transferred");
							long bal2 = sc.nextInt();
							long b=bal-bal2;
							long b1=bal1+bal2;
							bs.setBalance(accNo,b, " \n Amount debited Rs." + bal2);
							bs.setBalance(accNo1,b1, " \n Amount credited Rs." + bal2);
							System.out.println("Amount You transferred is " + bal2);
							System.out.println("Total balance is " + bs.getBalance(accNo));

						}
					}
				}
				break;
			case 6:
				System.out.println(" Enter Your Account number");
				accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.println("Enter your Password");
					String pass = sc.next();
					if (bs.checkPass(pass)) {
						System.out.println("*******************Mini Statment***************");
						String strn = bs.getTransaction(accNo);
						System.out.println(strn);
						System.out.println("Total balance is " + bs.getBalance(accNo));
						
					}
				}
				break;
			case 7:
				System.out.println(" Enter Your Account number");
			accNo = sc.nextLong();
			if (bs.checkAccNo(accNo)) {
				System.out.println("Enter your Password");
				String pass = sc.next();
				if (bs.checkPass(pass)) {
					WalletBean b = bs.getInfo(accNo);
					System.out.println("Your account info is \n Account Holder Name: "+b.getName()+"\n Account Number : "+b.getAccNo()+"\n Mobile Number : "+b.getMobile()+"\n balance : "+b.getBalance() );
				}
			}
			break;
		case 8:
				System.exit(0);
			default:
				System.out.println("enter proper choice");
				break;

			}

		}
	}
}