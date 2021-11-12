package com.ldms.demo.amortisation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Installment {
    private double amount;
    private double interestRate;
}
