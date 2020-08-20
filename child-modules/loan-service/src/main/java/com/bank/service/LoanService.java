package com.bank.service;

import com.bank.model.Loan;
import com.bank.repo.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService implements ILoanService {
    private LoanRepository loanRepository;

    @Override
    public Loan applyLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLoans(String pan) {
        return loanRepository.findLoansByPan(pan);
    }
}
