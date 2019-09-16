package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.CustomerDetails;
import com.cg.entities.TransactionDetails;
import com.cg.exception.AccountNotFoundException;
import com.cg.service.IService;

@RestController
@RequestMapping("/map")
public class CustomerController {
	@Autowired
	IService service;

	@PostMapping("/new")
	public CustomerDetails newAccount(@Valid @RequestBody CustomerDetails customerDetails) throws AccountNotFoundException {
		return service.newAccount(customerDetails);
	}

	@GetMapping("/displaydetails/{accountNo}")
	public CustomerDetails details(@PathVariable Long accountNo) throws AccountNotFoundException {
		return service.details(accountNo);
	}

	@GetMapping("/displayBalance/{accountNo}")
	public ResponseEntity<String> displayBalance(@PathVariable Long accountNo) throws AccountNotFoundException {
		Double balance = service.displayBalance(accountNo);
		return new ResponseEntity<String>("Available balance: " + balance, HttpStatus.OK);
	}

	@PutMapping("/depositAmount/{accountNo}/{amount}")
	public ResponseEntity<String> depositAmount(@Valid @PathVariable Long accountNo, @PathVariable Double amount) throws AccountNotFoundException {
		Double balance = service.depositAmount(accountNo, amount);
		return new ResponseEntity<String>("After deposited: " + balance, HttpStatus.OK);
	}

	@PutMapping("/withdraw/{accNo}/{amt}")
	public ResponseEntity<String> withdrawAmount(@Valid @PathVariable Long accNo, @PathVariable Double amt) throws AccountNotFoundException {
		Double balance = service.withdrawAmount(accNo, amt);
		return new ResponseEntity<String>("After withdrawn: " + balance, HttpStatus.OK);
	}

	@PutMapping("/fundTransfer/{accNo}/{amount}/{accNo1}")
	public ResponseEntity<String> fundTransfer(@Valid @PathVariable Long accNo, @PathVariable Double amount,
			@PathVariable Long accNo1) throws AccountNotFoundException {
		Double balance = service.fundTransfer(accNo, amount, accNo1);
		return new ResponseEntity<String>("Transaction Completed\n*****************************"
				+ "\nAmount transferred: "+amount
				+ "\nDeposited account number: "+accNo1+"\n*****************************\n"
				+ "After transaction: " +balance
				+ "\n*****************************", HttpStatus.OK);
	}

	@GetMapping("/print/{accNo}")
	public List<TransactionDetails> printTransactions(@PathVariable Long accNo) {
		return service.printTransactions(accNo);
	}

}
