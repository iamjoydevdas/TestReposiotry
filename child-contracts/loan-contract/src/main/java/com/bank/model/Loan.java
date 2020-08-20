package com.bank.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
public class Loan {
    @NonNull
    private String pan;
    @Id
    private String loanAccount;
    private LocalDate loanSanctionDate;
    private Integer loanDuration;
    private LoanType loanType;
    private Double rateOfInterest;
}
