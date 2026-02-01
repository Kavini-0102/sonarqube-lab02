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

    @Test
    void testAddition() {
        assertEquals(15, calculator.calculate(10, 5, "add"));
    }

    @Test
    void testAddAgain() {
        assertEquals(15, calculator.calculate(10, 5, "add-again"));
    }

    @Test
    void testSubtraction() {
        assertEquals(5, calculator.calculate(10, 5, "sub"));
    }

    @Test
    void testSubAgain() {
        assertEquals(5, calculator.calculate(10, 5, "sub-again"));
    }

    @Test
    void testMultiplication() {
        assertEquals(50, calculator.calculate(10, 5, "mul"));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.calculate(10, 5, "div"));
    }

    @Test
    void testDivisionByZero() {
        assertEquals(0, calculator.calculate(10, 0, "div"));
    }

    @Test
    void testModulo() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
    }

    @Test
    void testPower() {
        assertEquals(100, calculator.calculate(10, 2, "pow"));
        assertEquals(8, calculator.calculate(2, 3, "pow"));
        assertEquals(1, calculator.calculate(5, 0, "pow"));
    }

    @Test
    void testInvalidOperation() {
        assertEquals(0, calculator.calculate(10, 5, "invalid"));
        assertEquals(0, calculator.calculate(10, 5, "xyz"));
    }

    @Test
    void testAddNumbers() {
        assertEquals(15, calculator.addNumbers(10, 5));
        assertEquals(0, calculator.addNumbers(0, 0));
        assertEquals(-5, calculator.addNumbers(-10, 5));
    }

    @Test
    void testSumValues() {
        assertEquals(15, calculator.sumValues(10, 5));
        assertEquals(0, calculator.sumValues(0, 0));
        assertEquals(-5, calculator.sumValues(-10, 5));
    }

    @Test
    void testAddAgainMethod() {
        assertEquals(15, calculator.addAgain(10, 5));
        assertEquals(0, calculator.addAgain(0, 0));
        assertEquals(-5, calculator.addAgain(-10, 5));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-15, calculator.calculate(-10, -5, "add"));
        assertEquals(-5, calculator.calculate(-10, -5, "sub"));
        assertEquals(50, calculator.calculate(-10, -5, "mul"));
    }
}