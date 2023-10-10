package com.calculator.demo.controller;

import com.calculator.demo.Entity.CalculatorOperator;
import com.calculator.demo.exception.CalculatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.calculator.demo.Entity.Calculator;
import com.calculator.demo.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class CalculatorController {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody Calculator calculator) {
        try {
            double result = calculatorService.calculateNumbers(calculator);
            logger.info("Calculation request received for numbers {} {} with operator {}.", calculator.getNum1(), calculator.getNum2(), calculator.getOperator());
            return ResponseEntity.ok("Result: " + result);
        } catch (CalculatorException ex) {
            logger.error("Error occurred while calculating: {}", ex.getMessage(), ex);
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
            logger.info("Calculation request received for numbers {} {} with operator {}.", num1, num2, operator);
            return ResponseEntity.ok("Result: " + result);
        } catch (CalculatorException ex) {
            logger.error("Error occurred while calculating: {}", ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/square-root")
    public ResponseEntity<String> calculateSquareRoot(@RequestParam double num) {
        try {
            double result = calculatorService.calculateSquareRoot(num);
            logger.info("Square root calculation request received for number {}.", num);
            return ResponseEntity.ok("Square Root: " + result);
        } catch (CalculatorException ex) {
            logger.error("Error occurred while calculating square root: {}", ex.getMessage(), ex);
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
            logger.info("Exponentiation calculation request received for number {} with exponent {}.", num, exponent);
            return ResponseEntity.ok("Exponentiation: " + result);
        } catch (CalculatorException ex) {
            logger.error("Error occurred while calculating exponentiation: {}", ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
