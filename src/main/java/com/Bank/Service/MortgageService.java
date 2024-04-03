package com.Bank.Service;

import com.Bank.Model.Mortgage;
import org.springframework.stereotype.Service;

@Service
public class MortgageService {
    public double calculateMonthlyPayment(Mortgage mortgage) {
        int amount = mortgage.amount();
        double annualInterestRate = mortgage.interest();
        int lengthInYears = mortgage.length();
        if (amount <= 0 || annualInterestRate <= 0 || lengthInYears <= 0) {
            throw new IllegalArgumentException("Can not be equal or less than zero");
        }
        int numberOfPayments = lengthInYears * 12;
        double monthlyInterestRate = annualInterestRate / 12;
        double monthlyPayment = Math.floor((amount * monthlyInterestRate / 100) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments)));
        return monthlyPayment;
    }
}
