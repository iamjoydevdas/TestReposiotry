package com.bank.service;

import com.bank.model.Customer;
import com.bank.model.Loan;

public interface ICustomerService {
	void createCustomer(Customer cust);

	Loan applyLoan(Loan loan);

	Customer getCustomerDetails(String pan);

	Customer updateCustomer(Customer updatedCustomer);

	String login(String pan, String password);

	void logout(String token);
}
