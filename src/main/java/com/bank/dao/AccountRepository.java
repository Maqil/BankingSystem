package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	@Query("select a from Account a where a.codeAccount = :x")
	public Account findByCode(@Param("x") String codeAccount);

}
