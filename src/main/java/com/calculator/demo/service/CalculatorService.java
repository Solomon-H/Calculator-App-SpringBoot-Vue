package com.calculator.demo.service;

import org.springframework.stereotype.Service;
import com.calculator.demo.Entity.Calculator;
import com.calculator.demo.exception.CalculatorException;

@Service
public class CalculatorService {

    public double calculateNumbers(Calculator calculator) throws CalculatorException {
        double result = 0.0;

        switch (calculator.getOperator()) {
            case ADDITION:
                result = calculator.getNum1() + calculator.getNum2();
                break;

            case SUBTRACTION:
                result = calculator.getNum1() - calculator.getNum2();
                break;

            case MULTIPLICATION:
                result = calculator.getNum1() * calculator.getNum2();
                break;

            case DIVISION:
                if (calculator.getNum2() != 0) {
                    result = calculator.getNum1() / calculator.getNum2();
                } else {
                    throw new CalculatorException("You cannot divide by zero!");
                }
                break;
        }
        
        return result;
    }

    public double calculateSquareRoot(double num) {
        return Math.sqrt(num);
    }

    public double calculateExponentiation(double num, double exponent) {
        return Math.pow(num, exponent);
    }
}