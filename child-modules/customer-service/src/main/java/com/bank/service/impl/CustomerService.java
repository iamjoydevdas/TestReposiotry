package com.bank.service.impl;

import com.bank.exception.BankException;
import com.bank.feign.ILoanController;
import com.bank.model.Customer;
import com.bank.model.Loan;
import com.bank.repository.CustomerRepository;
import com.bank.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ILoanController loanController;

    @Override
	public void createCustomer(Customer cust) {

		if(!isDuplicateCustomer(cust.getCustomerPAN())) {
			customerRepository.save(cust);
		}
	}

    @Override
    public Loan applyLoan(Loan loan) {
        return null;// loanController.applyLoan(loan).getBody().getData();
    }

	@Override
	public Customer getCustomerDetails(String pan) {
    	Customer customer = customerRepository.findByCustomerPAN(pan);
    	//customer.setLoans(loanController.getAllLoans(pan).getBody().getData());
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer updatedCustomer) {
    	Customer customer = customerRepository.findByCustomerPAN(updatedCustomer.getCustomerPAN());
		Customer updatCustomer = new Customer(customer);
		return customerRepository.save(updatCustomer);
	}

    @Override
    public String login(String pan, String password) {
        Customer customer = customerRepository.findByCustomerPANAndPassword(pan, password);
        String token = RandomStringUtils.randomAlphabetic(100);
        return token;
    }

    @Override
    public void logout(String token) {

    }

    public boolean isDuplicateCustomer(String pan) {
        return customerRepository.findAllByCustomerPAN(pan)
                .filter(CollectionUtils::isNotEmpty)
                .map(customers -> customers.size() > 1)
                .orElseThrow(() -> new BankException("Customer already there."));
	}

}
