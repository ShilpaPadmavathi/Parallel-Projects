package com.cg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entities.CustomerDetails;

public interface CustomersI extends JpaRepository<CustomerDetails, Long> {

	@Query("select accountNo,name from CustomerDetails where accountNo =?1")
	Optional<CustomerDetails> accountsDetails(@Param("c") Long accountNo);

	@Query("select bal.balance from CustomerDetails bal where bal.accountNo =?1")
	Optional<Double> showBalance(@Param("c") Long accountNo);
}
