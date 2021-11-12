package com.ldms.demo.amortisation;


import org.springframework.stereotype.Service;

import static com.ldms.demo.util.NumberUtil.round;

@Service
public class InstallmentCalculator {
    private static final double MONTHS_IN_YEAR = 12;
    private static final double PERCENTAGE_AS_DECIMAL = 100;

    public Installment calculateInstallment(LoanDetails loanDetails) {
        double P = loanDetails.getAssetCost() - loanDetails.getDeposit();
        double r = loanDetails.getInterestRate() / MONTHS_IN_YEAR / PERCENTAGE_AS_DECIMAL;
        int n = loanDetails.getNumberOfMonthlyPayments();
        double monthlyRepayment;
        if(loanDetails.getBalloonPayment() == 0) {
            monthlyRepayment = P * ((r * Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1));
        } else {
            double B = loanDetails.getBalloonPayment();
            monthlyRepayment = (P - (B / (Math.pow((1 + r) , n)))) * (r / (1 - Math.pow((1 + r) , -n)));
        }
        monthlyRepayment = round(monthlyRepayment);
        return new Installment(monthlyRepayment, r);
    }


}
