package com.bank.feign;

import java.util.List;

import com.bank.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.bank.model.Account;
import com.bank.model.ServiceResponse;

@FeignClient(name="loan", configuration = FeignConfig.class)
public interface ILoanController {

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE, value = "/loan")
	public ResponseEntity<ServiceResponse<Loan>> applyLoan(@RequestBody Loan loan);

	
	@GetMapping(value="/{pan}/loans")
	public ResponseEntity<ServiceResponse<List<Loan>>> getAllLoans(@PathVariable("pan") String pan);
	
}
