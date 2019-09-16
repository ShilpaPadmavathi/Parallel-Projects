package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class TransactionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "b")
	private Integer transNo;
	private Long accno;
	private String transType;
	private Double previousBal;
	private Double currentBal;
	
	public Integer getTransNo() {
		return transNo;
	}
	public void setTransNo(Integer transNo) {
		this.transNo = transNo;
	}
	public Long getAccno() {
		return accno;
	}
	public void setAccno(Long accno) {
		this.accno = accno;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Double getPreviousBal() {
		return previousBal;
	}
	public void setPreviousBal(Double previousBal) {
		this.previousBal = previousBal;
	}
	public Double getCurrentBal() {
		return currentBal;
	}
	public void setCurrentBal(Double currentBal) {
		this.currentBal = currentBal;
	}
	@Override
	public String toString() {
		return "TransactionDetails [transNo=" + transNo + ", accno=" + accno + ", transType=" + transType
				+ ", previousBal=" + previousBal + ", currentBal=" + currentBal + "]";
	}
	public TransactionDetails() {
		super();
	}
	public TransactionDetails(Long accno, String transType, Double previousBal, Double currentBal) {
		super();
		this.accno = accno;
		this.transType = transType;
		this.previousBal = previousBal;
		this.currentBal = currentBal;
	}


}
