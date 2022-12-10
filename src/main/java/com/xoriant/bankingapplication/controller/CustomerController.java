package com.xoriant.bankingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xoriant.bankingapplication.command.LoginCommand;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;
import com.xoriant.bankingapplication.model.Transaction;
import com.xoriant.bankingapplication.service.AccountService;
import com.xoriant.bankingapplication.service.CustomerService;
import com.xoriant.bankingapplication.service.ManagerService;

@Controller
public class CustomerController {
	Customer customerMain;
	Manager managerMain;
	Account accountMain;
	Transaction transactionMain;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = {"/","/index"})
	public String index()
	{
//		m.addAttribute("command",new LoginCommand());
		return "index";
	}
	
	@RequestMapping(value = {"/customerLogin"})
	public String customerLogin(Model m) {
		
		m.addAttribute("command",new LoginCommand());
		return "customerLogin";
		}
	
	
	@RequestMapping(value = {"/managerLogin"})
	public String managerLogin(Model m) {
		
		m.addAttribute("command",new LoginCommand());
		return "managerLogin";
		}
	
	@RequestMapping(value = {"/newUserRegistration"})
	public String newUserRegistration() {
		
//		m.addAttribute("command",new LoginCommand());
		return "userregistration";
		}
	
	
	
	@RequestMapping(value = {"/Logout"})
	public String Logout() {
		
		//m.addAttribute("command",new LoginCommand());
		return "index";
		}
	
	@RequestMapping(value = {"/About"})
	public String About() {
		
		//m.addAttribute("command",new LoginCommand());
		return "about";
		}
	
	@RequestMapping(value = {"/Contact"})
	public String Contact() {
		
		//m.addAttribute("command",new LoginCommand());
		return "contact";
		}
	
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd,Model m)
	{
		Manager manager = managerService.login(cmd.getLoginName(), cmd.getPassword());
		managerMain= managerService.login(cmd.getLoginName(), cmd.getPassword());
		Customer customer = customerService.login(cmd.getLoginName(), cmd.getPassword());
		customerMain= customerService.login(cmd.getLoginName(), cmd.getPassword());
		if(customer!=null) 
		{
			m.addAttribute("err","Login Failed! Enter valid credentials.");
			return "customer";
		}
		else if(manager!=null)
		{
			return "manager";
		}
		
		else{
			return "index";
		}
	}
	@RequestMapping(value = {"/showcustomerbalance"})
	public String showBalance(Model m)
{
		Account account = accountService.getBalance(customerMain.getCustomerId());
		m.addAttribute("account", account);
		return "showcustomerbalance";

}
	
	@RequestMapping(value = {"/showministatement"})
	public String showMiniStatement(Model m) {
		
		List<Transaction> transaction = accountService.getMiniStatement(customerMain.getCustomerId());
		m.addAttribute("transaction", transaction);
		return "showministatement";
	}
	
	

}
