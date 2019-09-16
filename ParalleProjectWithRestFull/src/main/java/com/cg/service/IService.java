package com.cg.service;

import java.util.List;

import com.cg.entities.CustomerDetails;
import com.cg.entities.TransactionDetails;
import com.cg.exception.AccountNotFoundException;

public interface IService {

	CustomerDetails newAccount(CustomerDetails customerDetails) throws AccountNotFoundException;

	CustomerDetails details(Long accNo) throws AccountNotFoundException;

	Double displayBalance(Long accNo) throws AccountNotFoundException;

	Double depositAmount(Long accNo, Double amt) throws AccountNotFoundException;

	Double withdrawAmount(Long accNo, Double amt) throws AccountNotFoundException;

	Double fundTransfer(Long accNo, Double amt, Long accNo1) throws AccountNotFoundException;

	List<TransactionDetails> printTransactions(Long accNo);
}
