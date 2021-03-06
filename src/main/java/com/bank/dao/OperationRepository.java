package com.bank.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	@Query("select o from Operation o where o.account.codeAccount = :x order by o.dateOperation desc")
	public Page<Operation> operationList(@Param("x") String codeAccount, Pageable pageable);
}
