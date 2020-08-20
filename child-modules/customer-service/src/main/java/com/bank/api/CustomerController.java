package com.bank.api;

import com.bank.handlers.ResponseHandlers;
import com.bank.model.Customer;
import com.bank.model.ServiceResponse;
import com.bank.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<Customer>> createCustomer(@RequestBody Customer customer){
		customerService.createCustomer(customer);
		return new ResponseHandlers<String>().defaultResponse("Custer created successfully. Use PAN for login.", HttpStatus.CREATED);
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE, value = "/{pan}")
	public ResponseEntity<ServiceResponse<Customer>> getCustomer(@PathVariable("pan") String pan){
		return new ResponseHandlers<Customer>().defaultResponse(customerService.getCustomerDetails(pan));
	}

	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE, value = "/{pan}")
	public ResponseEntity<ServiceResponse<Customer>> updateCustomer(@PathVariable("pan") String pan){
		return new ResponseHandlers<Customer>().defaultResponse(customerService.getCustomerDetails(pan));
	}
}
