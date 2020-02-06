package com.bank;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

//import com.bank.dao.ClientRepository;
//import com.bank.dao.AccountRepository;
//import com.bank.dao.OperationRepository;
//import com.bank.entities.Client;
//import com.bank.entities.Account;
//import com.bank.entities.AccountCourant;
//import com.bank.entities.AccountEpargne;
//import com.bank.entities.Operation;
//import com.bank.entities.Payment;
//import com.bank.metier.BankMetierImpl;
//import com.bank.entities.Withdrawal;

@SpringBootApplication
public class BankingSystemApplication implements CommandLineRunner {
//	@Autowired
//	private ClientRepository clientRepository;
//	@Autowired
//	private AccountRepository accountRepository;
//	@Autowired
//	private OperationRepository operationRepository;
//	@Autowired
//	private BankMetierImpl bankMetier;

	public static void main(String[] args) {

		SpringApplication.run(BankingSystemApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		Client c1 = clientRepository.save(new Client("Kobe 2", "kobe.bryant@gmail.com"));
//		Client c2 = clientRepository.save(new Client("John 2", "John.Dee@gmail.com"));
//
//		Account cp1 = accountRepository.save(new AccountCourant("c1", new Date(), 90000, c1, 6000));
//		Account cp2 = accountRepository.save(new AccountEpargne("c2", new Date(), 180000, c2, 5.5));
//
//		operationRepository.save(new Payment(new Date(), 90343400, cp1));
//		operationRepository.save(new Payment(new Date(), 83434000, cp1));
//		operationRepository.save(new Payment(new Date(), 70343400, cp1));
//		operationRepository.save(new Withdrawal(new Date(), 43434000, cp1));
//
//		operationRepository.save(new Payment(new Date(), 500565650, cp2));
//		operationRepository.save(new Payment(new Date(), 705600, cp2));
//		operationRepository.save(new Payment(new Date(), 7878000, cp2));
//		operationRepository.save(new Withdrawal(new Date(), 343434000, cp2));

	}
}
