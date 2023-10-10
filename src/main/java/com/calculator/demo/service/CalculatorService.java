package com.calculator.demo.service;

import org.springframework.stereotype.Service;
import com.calculator.demo.Entity.Calculator;
import com.calculator.demo.exception.CalculatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class CalculatorService {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

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
        
        logger.info("Performed calculation: {} {} {} = {}", calculator.getNum1(), calculator.getOperator(), calculator.getNum2(), result);

        return result;
    }

    public double calculateSquareRoot(double num) {
        double result = Math.sqrt(num);
        logger.info("Calculated square root of {}: {}", num, result);
        return result;
    }

    public double calculateExponentiation(double num, double exponent) {
        double result = Math.pow(num, exponent);
        logger.info("Calculated {} to the power of {}: {}", num, exponent, result);
        return result;
    }
}
