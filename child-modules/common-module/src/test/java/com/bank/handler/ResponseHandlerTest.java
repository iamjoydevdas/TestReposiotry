package com.bank.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.bank.exception.BankException;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.ServiceResponse;

@RunWith(MockitoJUnitRunner.class)
public class ResponseHandlerTest {
	@InjectMocks
	ResponseHandlers responseHandlers;

	@Test
	public void defaultResponseStringTest() {
		String data = "Hello world";
		ServiceResponse<String> defaultResponse = (ServiceResponse<String>)responseHandlers.defaultResponse(data).getBody();
		assertEquals(data, defaultResponse.getData());
	}
	
	@Test
	public void handleExceptionsNotFoundTest() {
		BankException bankException = BankException.builder().errorCode(HttpStatus.NOT_FOUND)
															.errorMessage("No Data Found")
															.build();
		ServiceResponse<String> defaultResponse = (ServiceResponse<String>)responseHandlers.handleExceptions(bankException).getBody();
		assertEquals(false, defaultResponse.isSuccess());
		assertEquals(HttpStatus.NOT_FOUND, defaultResponse.getError().getErrorCode());
		assertEquals("No Data Found", defaultResponse.getError().getErrorMessage());
	}
	
	@Test
	public void handleExceptionsUnAuthorizedTest() {
		BankException bankException = BankException.builder()
															.errorCode(HttpStatus.UNAUTHORIZED)
															.errorMessage("UNAUTHORIZED")
															.build();
		ServiceResponse<String> defaultResponse = (ServiceResponse<String>)responseHandlers.handleExceptions(bankException).getBody();
		assertEquals(false, defaultResponse.isSuccess());
		assertEquals(HttpStatus.UNAUTHORIZED, defaultResponse.getError().getErrorCode());
		assertEquals("UNAUTHORIZED", defaultResponse.getError().getErrorMessage());
	}
}
