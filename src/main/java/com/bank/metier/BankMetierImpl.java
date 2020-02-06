package com.bank.metier;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountRepository;
import com.bank.dao.OperationRepository;
import com.bank.entities.Account;
import com.bank.entities.AccountCourant;
import com.bank.entities.Operation;
import com.bank.entities.Withdrawal;
import com.bank.entities.Payment;
import org.springframework.data.domain.PageRequest;

@Service
@Transactional
public class BankMetierImpl implements IBankMetier {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OperationRepository opertionRepository;

	@Override
	public Account searchAccount(String codeAccount1) {
		Account cp = accountRepository.findByCode(codeAccount1);
		System.out.println(codeAccount1);
		System.out.println("searchAccount :" + cp);
		// orElseGet( () -> getRandomName() );//
		return cp;
	}

	// public Account getRandomName() {
	// return null;
	// }

	@Override
	public void pay(String codeAccount1, double amount) {
		Account cp = searchAccount(codeAccount1);
		Payment v = new Payment(new Date(), amount, cp);
		opertionRepository.save(v);
		cp.setBalance(cp.getBalance() + amount);
		accountRepository.save(cp);
	}

	@Override
	public void withdraw(String codeAccount1, double amount) {
		Account cp = searchAccount(codeAccount1);
		double facilitesCaisse = 0;
		if (cp instanceof AccountCourant)
			facilitesCaisse = ((AccountCourant) cp).getDecouvert();
		if (cp.getBalance() + facilitesCaisse < amount)
			throw new RuntimeException("Balance insufficient");
		Withdrawal r = new Withdrawal(new Date(), amount, cp);
		opertionRepository.save(r);
		cp.setBalance(cp.getBalance() - amount);
		accountRepository.save(cp);
	}

	@Override
	public void transfer(String codeAccount1, String codeAccount2, double amount) {
		if (codeAccount1.equals(codeAccount2)) {
			throw new  RuntimeException("Cannot transfer to the same account");
		}
		withdraw(codeAccount1, amount);
		pay(codeAccount2, amount);
	}

	@Override
	public Page<Operation> operationList(String codeAccount1, int page, int size) {
		return opertionRepository.operationList(codeAccount1, PageRequest.of(page, size));
	}

}
