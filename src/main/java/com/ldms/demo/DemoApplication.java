package com.ldms.demo;

import com.ldms.demo.amortisation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {


	@Autowired
	private LoanDetailsRepository loanDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setAssetCost(20000 );
		loanDetails.setDeposit(5000);
		loanDetails.setInterestRate(7.5);
		loanDetails.setBalloonPayment(1000);
		loanDetails.setNumberOfMonthlyPayments(12);

		loanDetailsRepository.save(loanDetails);
	}
}
