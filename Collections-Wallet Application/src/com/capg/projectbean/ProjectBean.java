package com.capg.projectbean;

public class ProjectBean {
		 String uname;	
		 String password;
		 float balance;
		 String mobileNum;
		 long acctNo;
			public ProjectBean(String uname, String password, float balance, String mobileNum, long acctNo) {
				super();
				this.uname = uname;
				this.password = password;
				this.balance = balance;
				this.mobileNum = mobileNum;
				this.acctNo = acctNo;
			}
			public ProjectBean() {
				
			}
		public String getUname() {
			return uname;
		}



		public void setUname(String uname) {
			this.uname = uname;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public float getBalance() {
			return balance;
		}



		public void setBalance(float balance) {
			this.balance = balance;
		}



		public String getMobileNum() {
			return mobileNum;
		}



		public void setMobileNum(String mobileNum) {
			this.mobileNum = mobileNum;
		}



		public long getAcctNo() {
			return acctNo;
		}

		public void setAcctNo(long acctNo) {
			this.acctNo = acctNo;
		}
		@Override
		public String toString() {
		// TODO Auto-generated method stub
		return " "+uname+" "+password+" "+balance+" "+acctNo;
		}
		
	}