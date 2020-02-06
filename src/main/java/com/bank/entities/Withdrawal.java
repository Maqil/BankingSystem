package com.bank.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Withdrawal extends Operation {

	public Withdrawal() {
		super();

	}

	public Withdrawal(Date dateOperation, double amount, Account account) {
		super(dateOperation, amount, account);

	}

}
