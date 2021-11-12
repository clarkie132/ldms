package com.ldms.demo.amortisation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstallmentCalculatorTest {

    @Test
    void calculateInstallment() {
        InstallmentCalculator installmentCalculator = new InstallmentCalculator();
        LoanDetails loanDetails = new LoanDetails();
        loanDetails.setAssetCost(25000 );
        loanDetails.setDeposit(5000);
        loanDetails.setInterestRate(7.5);
        loanDetails.setNumberOfMonthlyPayments(60);
        Installment installment = installmentCalculator.calculateInstallment(loanDetails);
        assertEquals(0.00625, installment.getInterestRate());
        assertEquals(400.76, installment.getAmount());

    }
}