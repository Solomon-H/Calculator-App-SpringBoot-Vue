package com.calculator.demo;
import com.calculator.demo.Entity.Calculator;
import com.calculator.demo.Entity.CalculatorOperator;
import com.calculator.demo.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorApplicationTests {

	private CalculatorService calculatorService = new CalculatorService();

	@Test
	public void addNum1ToNum2() {
		Calculator calculator = new Calculator(10, 10, CalculatorOperator.ADDITION);
		double result = calculatorService.calculateNumbers(calculator);
		assertEquals(20, result);
	}

	@Test
	public void addNegativeNumbers() {
		Calculator calculator = new Calculator(-10, -5, CalculatorOperator.ADDITION);
		double result = calculatorService.calculateNumbers(calculator);
		assertEquals(-15, result);
	}

	@Test
	public void subNum1FromNum2() {
		Calculator calculator = new Calculator(10, 5, CalculatorOperator.SUBTRACTION);
		double result = calculatorService.calculateNumbers(calculator);
		assertEquals(5, result);
	}

	@Test
	public void subNegativeFromPositive() {
		Calculator calculator = new Calculator(10, -5, CalculatorOperator.SUBTRACTION);
		double result = calculatorService.calculateNumbers(calculator);
		assertEquals(15, result);
	}

	@Test
	public void multiplyNum1ByNum2() {
		Calculator calculator = new Calculator(5, 5, CalculatorOperator.MULTIPLICATION);
		double result = calculatorService.calculateNumbers(calculator);
		assertEquals(25, result);
	}

	@Test
	public void multiplyNegativeNumbers() {
		Calculator calculator = new Calculator(-3, -4, CalculatorOperator.MULTIPLICATION);
		double result = calculatorService.calculateNumbers(calculator);
		assertEquals(12, result);
	}

	@Test
	public void divNum1ToNum2() {
		Calculator calculator = new Calculator(10, 2, CalculatorOperator.DIVISION);
		double result = calculatorService.calculateNumbers(calculator);
		assertEquals(5, result);
	}

	@Test
	public void divNegativeByPositive() {
		Calculator calculator = new Calculator(-10, 2, CalculatorOperator.DIVISION);
		double result = calculatorService.calculateNumbers(calculator);
		assertEquals(-5, result);
	}

//	@Test
//	public void divToZero() {
//		Calculator calculator = new Calculator(10, 0, CalculatorOperator.DIVISION);
//		double result = calculatorService.calculateNumbers(calculator);
//		assertEquals(0, result);
//	}
}
