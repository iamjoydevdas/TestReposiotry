package com.bank.feign;

import com.bank.model.Customer;
import com.bank.model.Loan;
import com.bank.model.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="login", configuration = FeignConfig.class)
public interface ILoginController {

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE, value = "/loan")
	public ResponseEntity<ServiceResponse<String>> login(@RequestHeader("pan") String pan, @RequestHeader("password") String password);

	
	@GetMapping(value="/{pan}/loans")
	public ResponseEntity<ServiceResponse<String>> logout(@RequestHeader("token") String token);
	
}
