package com.bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.entities.Account;
import com.bank.entities.Operation;
import com.bank.metier.IBankMetier;

@Controller
public class BanqueController {
	@Autowired
	private IBankMetier bankMetier;

	@RequestMapping("/operations")
	public String index() {
		return "accounts";
	}

	@RequestMapping("/consultAccount")
	public String consult(Model model, String codeAccount, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		model.addAttribute("codeAccount", codeAccount);
		try {
			Account account = bankMetier.searchAccount(codeAccount);
			Page<Operation> pageOperations = bankMetier.operationList(codeAccount, page, size);
			model.addAttribute("operationsList", pageOperations.getContent());
			int[] pages = new int[pageOperations.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("account", account);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "accounts";
	}

	@RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
	public String saveOperation(Model model, String typeOperation, String codeAccount, double amount,
			String codeAccount2) {
		try {
			if (typeOperation.equals("PAY")) {
				bankMetier.pay(codeAccount, amount);
			} else if (typeOperation.equals("WITHDRAW")) {
				bankMetier.withdraw(codeAccount, amount);
			}
			if (typeOperation.equals("TRANSFER")) {
				bankMetier.transfer(codeAccount, codeAccount2, amount);
			}
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consultAccount?codeAccount=" + codeAccount + "&error=" + e.getMessage();
		}
		return "redirect:/consultAccount?codeAccount=" + codeAccount;
	}
}
