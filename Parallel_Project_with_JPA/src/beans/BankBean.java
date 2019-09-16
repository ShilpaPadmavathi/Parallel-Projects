package beans;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity

@Table(name="Banking")
public class BankBean {

	int i = 0;
	
	@Column
	private String name;
	@Column
	private long mobile;
	@Column
	private long balance;
	@Column
	private String password;
	@Column
	private String tran;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="my_seq_acc")
	@SequenceGenerator(name="my_seq_acc",sequenceName="genAcc")
	@Column
	private long accNo;
public BankBean() {}
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

	public BankBean(String name, long mobile, String password, long bal, String tan)
			 {

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