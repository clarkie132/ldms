package com.ldms.demo.amortisation;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class AmortisationScheduleEntry {
    private int period;
    private double payment;
    private double principal;
    private double interest;
    private double balance;
}
