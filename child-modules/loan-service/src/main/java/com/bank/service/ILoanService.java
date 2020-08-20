package com.bank.service;

import com.bank.model.Loan;

import java.util.List;

public interface ILoanService {
    Loan applyLoan(Loan loan);
    List<Loan> getAllLoans(String pan);
}
