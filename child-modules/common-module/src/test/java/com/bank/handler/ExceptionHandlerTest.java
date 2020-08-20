package com.bank.handler;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bank.exception.BankException;
import com.bank.handlers.ExceptionHandlers;
import com.bank.model.ServiceResponse;
import com.bank.model.ServiceResponse.Errors;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionHandlerTest {
	
	@InjectMocks
	ExceptionHandlers exceptionHanlders;
	
	@Test
	public void exceptionForNotFounTest() {
		BankException bse = new BankException("Not Found");
		ResponseEntity<Object> exception = exceptionHanlders.exception(bse);
		Errors error = ((ServiceResponse<?>)exception.getBody()).getError();
		assertEquals(HttpStatus.NOT_FOUND, error.getErrorCode());
		assertEquals("Not Found", error.getErrorMessage());
		assertTrue(!((ServiceResponse<?>)exception.getBody()).isSuccess());
	}

}
