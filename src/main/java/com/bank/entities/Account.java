package com.bank.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String codeAccount;
	private Date dateCreate;
	private double balance;
	@ManyToOne
	@JoinColumn(name = "CODE_CLI")
	private Client client;
	@OneToMany(mappedBy = "account")
	private Collection<Operation> operations;

	public Account() {
		super();
	}

	public Account(String codeAccount, Date dateCreate, double balance, Client client) {
		super();
		this.codeAccount = codeAccount;
		this.dateCreate = dateCreate;
		this.balance = balance;
		this.client = client;
	}

	public String getCodeAccount() {
		return codeAccount;
	}

	public void setCodeAccount(String codeAccount) {
		this.codeAccount = codeAccount;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		return "Account [codeAccount=" + codeAccount + ", dateCreate=" + dateCreate + ", balance=" + balance + "]";
	}

}
