package com.calculator.demo.controller;

import com.calculator.demo.Entity.CalculatorOperator;
import com.calculator.demo.exception.CalculatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.calculator.demo.Entity.Calculator;
import com.calculator.demo.service.CalculatorService;


@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody Calculator calculator) {
        try {
            double result = calculatorService.calculateNumbers(calculator);
            return ResponseEntity.ok("Result: " + result);
        } catch (CalculatorException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/calculates")
    public ResponseEntity<String> calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam CalculatorOperator operator
    ) {
        try {
            Calculator calculator = new Calculator(num1, num2, operator);
            double result = calculatorService.calculateNumbers(calculator);
            return ResponseEntity.ok("Result: " + result);
        } catch (CalculatorException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/square-root")
    public ResponseEntity<String> calculateSquareRoot(@RequestParam double num) {
        try {
            double result = calculatorService.calculateSquareRoot(num);
            return ResponseEntity.ok("Square Root: " + result);
        } catch (CalculatorException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/exponentiation")
    public ResponseEntity<String> calculateExponentiation(
            @RequestParam double num,
            @RequestParam double exponent
    ) {
        try {
            double result = calculatorService.calculateExponentiation(num, exponent);
            return ResponseEntity.ok("Exponentiation: " + result);
        } catch (CalculatorException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
