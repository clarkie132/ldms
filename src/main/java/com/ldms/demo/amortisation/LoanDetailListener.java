package com.ldms.demo.amortisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class LoanDetailListener {

    private final AmortisationScheduleService amortisationScheduleService;

    public LoanDetailListener(AmortisationScheduleService amortisationScheduleService) {
        this.amortisationScheduleService = amortisationScheduleService;
    }

    @PrePersist
    @PreUpdate
    private void beforeAnyUpdate(LoanDetails  loanDetails) {
        loanDetails.setAmortisationSchedule(amortisationScheduleService.calculateAmortisationSchedule(loanDetails));
    }
}
