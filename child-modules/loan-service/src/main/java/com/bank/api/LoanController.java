package com.bank.api;

import com.bank.feign.ILoanController;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.Loan;
import com.bank.model.ServiceResponse;
import com.bank.service.ILoanService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class LoanController implements ILoanController {

    @Autowired
    private ILoanService loanService;

    @Override
    public ResponseEntity<ServiceResponse<Loan>> applyLoan(Loan loan) {
        return new ResponseHandlers<Loan>().defaultResponse(loanService.applyLoan(loan),"Loan added successfully.", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ServiceResponse<List<Loan>>> getAllLoans(String pan) {
        return new ResponseHandlers<List<Loan>>().defaultResponse(loanService.getAllLoans(pan));
    }
}
