package ui;

import java.sql.SQLException;
import java.util.Scanner;

import beans.BankBean;
import beans.CustomerAddress;
import service.BankService;
import service.BankService1;

//This creates a user interface for user so that the user can connect with database
public class BankUI {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in); // Scanner Object for Taking Input from User
		BankService1 bank = new BankService();
		int i = 1001;
		while (true) {
			System.out.println("Welcome to Pay Wallet");
			System.out.println("*****");
			System.out.println("1.Create Account");
			System.out.println("2.Show Balance");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw ");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transactions");
			System.out.println("7. Exit");
			System.out.print("Enter Your Choice :");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter your name :");
				String name = sc.next();
				name += sc.nextLine();
				while (!bank.checkName(name)) {
					System.out.print("Enter your name :");
					name = sc.next();
					name += sc.nextLine();
				}

				System.out.print("Enter your mobile number:");
				long mobile = sc.nextLong();
				while (!bank.checkMobile(mobile)) {
					System.out.print("Enter your mobile number :");
					mobile = sc.nextLong();
				}

				System.out.print("Enter a password :");
				String password = sc.next();
				while (!bank.checkPassword(password)) {
					System.out.print("    Enter a password :");
					password = sc.next();
				}
				String create = bank.addAccount(name, mobile, password);
				i++;
				System.out.print( create +"\n");
				break;
			case 2:
				System.out.print("Enter Your Account number:");
				long account = sc.nextLong();
				if (bank.checkAccount(account)) {
					System.out.print("Enter your Password:");
					String pass = sc.next();
					if (bank.checkPass(pass,account)) {
						long bal = bank.getBalance(account);
						System.out.print("    Your account balance is : Rs." + bal + "\n");
					}
				}

				break;
			case 3:
				System.out.print("Enter Your Account number : ");
				account = sc.nextLong();
				if (bank.checkAccount(account)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bank.checkPass(pass,account)) {

						System.out.print("Enter the deposit amount");
						long balance = sc.nextInt();
						long bal = bank.getBalance(account) + balance;

						bank.setBalance(account, bal, "\n TransID : " + i + "Amount credited  Rs." + balance);
						i++;
						System.out.print(" Amount You deposited is Rs." + balance + "\n");
						System.out.print(" Total balance is Rs." + bank.getBalance(account) + "\n");

					}
				}
				break;
			case 4:
				System.out.print("    Enter Your Account number : ");
				account = sc.nextLong();
				if (bank.checkAccount(account)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bank.checkPass(pass,account)) {

						System.out.print("    Enter the amount to be withdrawn : Rs.");
						long balance = sc.nextInt();
						long bal = bank.getBalance(account) - balance;
						bank.setBalance(account, bal, "\n    TransID : " + i + "       Amount debited    Rs." + balance);
						System.out.print("    Amount You withdraw is Rs." + balance + "\n");
						System.out.print("    Total balance is Rs." + bank.getBalance(account) + "\n");
						i++;
					}
				}
				break;
			case 5:
				System.out.print("    Enter Your Account number : ");
				account = sc.nextLong();
				if (bank.checkAccount(account)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bank.checkPass(pass,account)) {
						System.out.print("Enter Account number where you want to transer fund : ");
						long accNo1 = sc.nextLong();
						if (bank.checkAccount(accNo1)) {
							long bal = bank.getBalance(account);
							long bal1 = bank.getBalance(accNo1);

							System.out.print("    Enter the amount to be transferred : Rs.");
							long bal2 = sc.nextInt();
							bank.setBalance(account, bal - bal2, "\n TransID"+i+"Amount debited    Rs."
									+ bal2 + "  to Account Number " + accNo1);
							bank.setBalance(accNo1, bal1 + bal2, "\n    TransID : " + i + "        Amount credited  Rs."
									+ bal2 + "  from Account Number " + account);
							System.out.print("    Amount You transferred is Rs." + bal2 + "\n");
							System.out.println("    Total balance is Rs." + bank.getBalance(account) + "\n");
							i++;
						}
					}
				}
				break;
			case 6:
				System.out.print("Enter Your Account number");
				account = sc.nextLong();
				if (bank.checkAccount(account)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bank.checkPass(pass,account)) {
						System.out.print("\n Transactions Are\n");
						String strn = bank.getTransaction(account);
						System.out.print(strn + "\n");
						System.out.print("Total balance is Rs." + bank.getBalance(account) + "\n");

					}
				}
				break;
			case 7:
				System.out.println("Thanks For Using the Application");
				System.exit(0);
			default:
				System.out.println("Enter a Valid Choice");
				break;

			}

		}
	}
}