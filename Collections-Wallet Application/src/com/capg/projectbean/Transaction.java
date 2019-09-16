package com.capg.projectbean;

public class Transaction {
	private int transId;
	private String transDate;
	private String transType;
	private float balance;
	private long accFrom;
	private long accTo;

	public Transaction(int transId, String transDate, String transType, float balance, long accFrom, long accTo) {
		super();
		this.transId = transId;
		this.transDate = transDate;
		this.transType = transType;
		this.balance = balance;
		this.accFrom = accFrom;
		this.accTo = accTo;
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public long getAccFrom() {
		return accFrom;
	}

	public void setAccFrom(long accFrom) {
		this.accFrom = accFrom;
	}

	public long getAccTo() {
		return accTo;
	}

	public void setAccTo(long accTo) {
		this.accTo = accTo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " " + transId + " " + transDate + " " + balance+" "+transType+" "+accFrom+" "+accTo;
	}

}
