package com.calculator.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Calculator {

    @Id
    private Long id;
    private double num1;
    private double num2;
    private CalculatorOperator operator;


    public Calculator () {}

    public Calculator(double num1, double num2, CalculatorOperator operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
}




