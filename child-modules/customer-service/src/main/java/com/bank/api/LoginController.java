package com.bank.api;

import com.bank.feign.ILoginController;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.ServiceResponse;
import com.bank.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController implements ILoginController {

    private ICustomerService customerService;

    @Override
    public ResponseEntity<ServiceResponse<String>> login(String pan, String password) {
        return new ResponseHandlers<String>().defaultResponse(customerService.login(pan, password));
    }

    @Override
    public ResponseEntity<ServiceResponse<String>> logout(String token) {
        customerService.logout(token);
        return new ResponseHandlers<String>().defaultResponse("Customer logged out successfully.");
    }
}
