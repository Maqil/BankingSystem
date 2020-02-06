package com.bank.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class AccountCourant extends Account {
	private double decouvert;

	public AccountCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountCourant(String codeAccount, Date dateCreate, double balance, Client client, double decouvert) {
		super(codeAccount, dateCreate, balance, client);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

}
