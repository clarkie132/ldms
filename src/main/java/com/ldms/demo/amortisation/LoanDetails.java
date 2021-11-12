package com.ldms.demo.amortisation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@EntityListeners(LoanDetailListener.class)
public class LoanDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numberOfMonthlyPayments;
    private double assetCost;
    private double deposit;
    private double interestRate;
    private double balloonPayment;

    @ElementCollection
    private List<AmortisationScheduleEntry> amortisationSchedule;
}
