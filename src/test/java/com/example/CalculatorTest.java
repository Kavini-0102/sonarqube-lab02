package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // Test all operations in calculate()
    @Test
    void testAddition() {
        int result = calculator.calculate(10, 5, "add");
        assertEquals(15, result);
    }

    @Test
    void testAddAgain() {
        int result = calculator.calculate(10, 5, "add-again");
        assertEquals(15, result);
    }

    @Test
    void testSubtraction() {
        int result = calculator.calculate(10, 5, "sub");
        assertEquals(5, result);
    }

    @Test
    void testSubAgain() {
        int result = calculator.calculate(10, 5, "sub-again");
        assertEquals(5, result);
    }

    @Test
    void testMultiplication() {
        int result = calculator.calculate(10, 5, "mul");
        assertEquals(50, result);
    }

    @Test
    void testDivision() {
        int result = calculator.calculate(10, 5, "div");
        assertEquals(2, result);
    }

    @Test
    void testDivisionByZero() {
        int result = calculator.calculate(10, 0, "div");
        assertEquals(0, result);
    }

    @Test
    void testDivisionElseBranch() {
        int result = calculator.calculate(9, 3, "div");
        assertEquals(3, result);
    }

    @Test
    void testModulo() {
        int result = calculator.calculate(10, 3, "mod");
        assertEquals(1, result);
    }

    @Test
    void testPower() {
        int result = calculator.calculate(2, 3, "pow");
        assertEquals(8, result);
    }

    @Test
    void testPowerZero() {
        int result = calculator.calculate(5, 0, "pow");
        assertEquals(1, result);
    }

    @Test
    void testPowerMultipleIterations() {
        int result = calculator.calculate(2, 5, "pow");
        assertEquals(32, result);
    }

    @Test
    void testInvalidOperation() {
        int result = calculator.calculate(10, 5, "invalid");
        assertEquals(0, result);
    }

    // Test duplicate methods
    @Test
    void testAddNumbers() {
        int result = calculator.addNumbers(10, 5);
        assertEquals(15, result);
    }

    @Test
    void testSumValues() {
        int result = calculator.sumValues(10, 5);
        assertEquals(15, result);
    }

    @Test
    void testAddAgainMethod() {
        int result = calculator.addAgain(10, 5);
        assertEquals(15, result);
    }

    // Additional edge cases
    @Test
    void testNegativeNumbers() {
        assertEquals(-15, calculator.calculate(-10, -5, "add"));
        assertEquals(-5, calculator.calculate(-10, -5, "sub"));
        assertEquals(50, calculator.calculate(-10, -5, "mul"));
    }

    @Test
    void testZeroValues() {
        assertEquals(0, calculator.calculate(0, 0, "add"));
        assertEquals(0, calculator.calculate(0, 5, "mul"));
        assertEquals(1, calculator.calculate(0, 0, "pow"));
    }
}