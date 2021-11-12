package com.ldms.demo.amortisation;

import com.ldms.demo.util.NumberUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.ldms.demo.util.NumberUtil.round;

@Service
public class AmortisationScheduleService {
    private static final BigDecimal MONTHS_IN_YEAR = new BigDecimal("12");

    private final InstallmentCalculator installmentCalculator;

    public AmortisationScheduleService(InstallmentCalculator installmentCalculator) {
        this.installmentCalculator = installmentCalculator;
    }

    public List<AmortisationScheduleEntry> calculateAmortisationSchedule(LoanDetails loanDetails) {
        List<AmortisationScheduleEntry> scheduleEntries = new ArrayList<>();
        Installment installment = installmentCalculator.calculateInstallment(loanDetails);
        AmortisationScheduleEntry entry = new AmortisationScheduleEntry();
        entry.setPeriod(0);
        entry.setPayment(round(installment.getAmount()));
        entry.setInterest(round(installment.getInterestRate() * loanDetails.getAssetCost()));
        entry.setPrincipal(round(installment.getAmount() - entry.getInterest()));
        entry.setBalance(round(loanDetails.getAssetCost() - entry.getPrincipal()));
        scheduleEntries.add(entry);
        for (int i = 1; i <= loanDetails.getNumberOfMonthlyPayments()-1; i ++ ) {
            AmortisationScheduleEntry newEntry = new AmortisationScheduleEntry();
            newEntry.setPeriod(i);
            newEntry.setPayment(round(installment.getAmount()));
            newEntry.setInterest(round(installment.getInterestRate() * entry.getBalance()));
            newEntry.setPrincipal(round(installment.getAmount() - newEntry.getInterest()));
            newEntry.setBalance(round(entry.getBalance() - newEntry.getPrincipal()));
            scheduleEntries.add(newEntry);
            entry = newEntry;
        }
        if(loanDetails.getBalloonPayment() != 0) {
            entry.setPayment(loanDetails.getBalloonPayment());
        }
        return scheduleEntries;
    }


}
