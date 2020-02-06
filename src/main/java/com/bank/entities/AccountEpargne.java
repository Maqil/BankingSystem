package com.bank.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class AccountEpargne extends Account {
	private double rate;

	public AccountEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountEpargne(String codeAccount, Date dateCreate, double balance, Client client, double rate) {
		super(codeAccount, dateCreate, balance, client);
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
