package com.ldms.demo.amortisation;

import com.ldms.demo.util.NumberUtil;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AmortisationScheduleServiceTest {

    @Mock
    private InstallmentCalculator installmentCalculator;

    @InjectMocks
    private AmortisationScheduleService amortisationScheduleService;
    @Test
    void calculateAmortisationSchedule() {

        LoanDetails loanDetails = new LoanDetails();
        loanDetails.setAssetCost(20000 );
        loanDetails.setDeposit(5000);
        loanDetails.setInterestRate(7.5);
        loanDetails.setNumberOfMonthlyPayments(12);
        Installment installment = new Installment(1735.15, 0.00625);
        Mockito.when(installmentCalculator.calculateInstallment(loanDetails)).thenReturn(installment);
        List<AmortisationScheduleEntry> response = amortisationScheduleService.calculateAmortisationSchedule(loanDetails);
        // This is a terrible thing to test but time!
        assertEquals(12, response.size());
    }

    @Test
    void calculateAmortisationScheduleWithBalloonPayment() {

        LoanDetails loanDetails = new LoanDetails();
        loanDetails.setAssetCost(20000 );
        loanDetails.setDeposit(5000);
        loanDetails.setInterestRate(7.5);
        loanDetails.setBalloonPayment(1000);
        loanDetails.setNumberOfMonthlyPayments(12);
        Installment installment = new Installment(1735.15, 0.00625);
        Mockito.when(installmentCalculator.calculateInstallment(loanDetails)).thenReturn(installment);
        List<AmortisationScheduleEntry> response = amortisationScheduleService.calculateAmortisationSchedule(loanDetails);

        assertEquals(loanDetails.getBalloonPayment(), response.get(11).getPayment());
    }
}