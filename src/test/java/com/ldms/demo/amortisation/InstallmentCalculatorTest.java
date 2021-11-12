package com.ldms.demo.amortisation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstallmentCalculatorTest {

    @Test
    void calculateInstallment() {
        InstallmentCalculator installmentCalculator = new InstallmentCalculator();
        LoanDetails loanDetails = new LoanDetails();
        loanDetails.setAssetCost(20000 );
        loanDetails.setInterestRate(7.5);
        loanDetails.setBalloonPayment(0);
        loanDetails.setNumberOfMonthlyPayments(12);
        Installment installment = installmentCalculator.calculateInstallment(loanDetails);
        assertEquals(0.00625, installment.getInterestRate());
        assertEquals(1735.15, installment.getAmount());

    }
}