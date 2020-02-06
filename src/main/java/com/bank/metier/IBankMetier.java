package com.bank.metier;

import org.springframework.data.domain.Page;

import com.bank.entities.Account;
import com.bank.entities.Operation;

public interface IBankMetier {
	public Account searchAccount(String codeAccount);

	public void pay(String codeAccount, double amount);

	public void withdraw(String codeAccount, double amount);

	public void transfer(String codeAccount1, String codeAccount2, double amount);

	public Page<Operation> operationList(String codeAccount, int page, int size);
}
