package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entities.TransactionDetails;

public interface ITransactionDetails extends JpaRepository<TransactionDetails, Integer> {

	@Query("from TransactionDetails where accNo=?1")
	List<TransactionDetails> printTransaction(Long accNo);

}
