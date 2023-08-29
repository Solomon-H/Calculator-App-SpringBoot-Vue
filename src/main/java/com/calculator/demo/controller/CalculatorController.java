package com.calculator.demo.controller;
import com.calculator.demo.Entity.CalculatorOperator;
import com.calculator.demo.exception.CalculatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.calculator.demo.Entity.Calculator;
import com.calculator.demo.service.CalculatorService;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculates")
    public ResponseEntity<String> getCalculate(@RequestParam double num1, @RequestParam double num2, @RequestParam CalculatorOperator operator) {
        try {
            Calculator calculator = new Calculator(num1, num2, operator);
            double result = calculatorService.calculateNumbers(calculator);
            return ResponseEntity.ok("Check your result: " + result);
        } catch (CalculatorException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/calculates")
    public ResponseEntity<String> postCalculate(@RequestBody Calculator calculator) {
        try {
            double result = calculatorService.calculateNumbers(calculator);
            return ResponseEntity.ok("Your post is successful!");
        } catch (CalculatorException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}




