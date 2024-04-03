package com.Bank.Controller;

import com.Bank.Model.Mortgage;
import com.Bank.Service.MortgageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
    private final MortgageService mortgageService;

    public BankController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }

    @GetMapping("/rate")
    public String Rate() {
        return "Wydaje sie trudne dopóki nie stanie się proste";
    }

    @PostMapping("/rate2")
    public ResponseEntity<Double> handle(@RequestBody Mortgage mortgage) {
        double monthlyPayment = mortgageService.calculateMonthlyPayment(mortgage);
        return ResponseEntity.ok(monthlyPayment);
    }

    @PostMapping("/JSON")
    public ResponseEntity<String> sendJson(@RequestBody String jsonRequest) {
        System.out.println("Otrzymano Json" + jsonRequest);
        String jsonResponse = "{\"response\": \"success\"}";
        return ResponseEntity.status(HttpStatus.OK).body((jsonResponse));
    }


}


