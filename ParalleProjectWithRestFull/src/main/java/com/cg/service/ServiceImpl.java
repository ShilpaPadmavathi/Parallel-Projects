package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CustomersI;
import com.cg.dao.ITransactionDetails;
import com.cg.entities.CustomerDetails;
import com.cg.entities.TransactionDetails;
import com.cg.exception.AccountNotFoundException;

@Service
public class ServiceImpl implements IService {

	@Autowired
	CustomersI customerDao;

	@Autowired
	ITransactionDetails transactionDao;

	@Override
	public CustomerDetails newAccount(CustomerDetails customerDetails) throws AccountNotFoundException {
		if (customerDetails.getBalance() == null || customerDetails.getBalance()<= 0) {
			throw new AccountNotFoundException("Atleast initial balance should be more than zero");
		} else {
			customerDao.save(customerDetails);
			return customerDao.findById(customerDetails.getAccountNo()).get();
		}
	}

	@Override
	public CustomerDetails details(Long accNo) throws AccountNotFoundException {
		if (!customerDao.findById(accNo).isPresent()) {
			throw new AccountNotFoundException("Invalid account number!!!");
		} else {
			return customerDao.findById(accNo).get();
		}
	}

	@Override
	public Double displayBalance(Long accNo) throws AccountNotFoundException {
		if (!customerDao.findById(accNo).isPresent()) {
			throw new AccountNotFoundException("Invalid account number!!!");
		} else {
			return customerDao.findById(accNo).get().getBalance();
		}

	}

	@Override
	public Double depositAmount(Long accountNo, Double amount) throws AccountNotFoundException {

		Optional<CustomerDetails> bank = customerDao.findById(accountNo);
		if (bank.isPresent()) {
			CustomerDetails tempEntity = bank.get();
			tempEntity.setBalance(bank.get().getBalance() + amount);
			customerDao.save(tempEntity);
			TransactionDetails trans = new TransactionDetails(accountNo, "Deposit", bank.get().getBalance(),
					bank.get().getBalance() + amount);
			transactionDao.save(trans);
			return displayBalance(accountNo);
		} else {
			throw new AccountNotFoundException("Invalid account number!!!");
		}
	}

	@Override
	public Double withdrawAmount(Long accNo, Double amt) throws AccountNotFoundException {
		Optional<CustomerDetails> bank = customerDao.findById(accNo);
		if (bank.isPresent()) {
			if (amt > displayBalance(accNo)) {
				throw new AccountNotFoundException("Low balance");
			} else {
				CustomerDetails tempEntity = bank.get();
				tempEntity.setBalance(bank.get().getBalance() - amt);
				customerDao.save(tempEntity);
				TransactionDetails trans = new TransactionDetails(accNo, "Withdraw", bank.get().getBalance(),
						bank.get().getBalance() - amt);
				transactionDao.save(trans);
				return displayBalance(accNo);
			}
		} else {
			throw new AccountNotFoundException("Invalid account number!!!");
		}
	}

	@Override
	public Double fundTransfer(Long accNo, Double amt, Long accNo1) throws AccountNotFoundException {
		Optional<CustomerDetails> senderAccount = customerDao.findById(accNo);
		Optional<CustomerDetails> reciverAccount = customerDao.findById(accNo1);
		if (senderAccount.isPresent() && reciverAccount.isPresent()) {

			CustomerDetails sender = senderAccount.get();
			sender.setBalance(senderAccount.get().getBalance() - amt);
			customerDao.save(sender);

			CustomerDetails reciver = reciverAccount.get();
			reciver.setBalance(reciverAccount.get().getBalance() + amt);
			customerDao.save(reciver);

			TransactionDetails senderTrans = new TransactionDetails(accNo, "Fund transfer",
					senderAccount.get().getBalance(), senderAccount.get().getBalance() - amt);
			transactionDao.save(senderTrans);

			TransactionDetails reciverTrans = new TransactionDetails(accNo1, "Fund recieved",
					reciverAccount.get().getBalance(), amt + reciverAccount.get().getBalance());
			transactionDao.save(reciverTrans);

			return displayBalance(accNo);
		} else {
			throw new AccountNotFoundException("Invalid account number!!!");
		}
	}

	@Override
	public List<TransactionDetails> printTransactions(Long accNo) {

		return transactionDao.printTransaction(accNo);
	}
}
