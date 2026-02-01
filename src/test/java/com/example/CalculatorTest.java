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
    void testAdd() {
        assertEquals(15, calculator.calculate(10, 5, "add"));
    }

    @Test
    void testAddAgain() {
        assertEquals(15, calculator.calculate(10, 5, "add-again"));
    }

    @Test
    void testSub() {
        assertEquals(5, calculator.calculate(10, 5, "sub"));
    }

    @Test
    void testSubAgain() {
        assertEquals(5, calculator.calculate(10, 5, "sub-again"));
    }

    @Test
    void testMul() {
        assertEquals(50, calculator.calculate(10, 5, "mul"));
    }

    @Test
    void testDivWhenBIsZero() {
        assertEquals(0, calculator.calculate(10, 0, "div"));
    }

    @Test
    void testDivWhenBIsNotZero() {
        assertEquals(2, calculator.calculate(10, 5, "div"));
    }

    @Test
    void testMod() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
    }

    @Test
    void testPowWithZeroExponent() {
        assertEquals(1, calculator.calculate(5, 0, "pow"));
    }

    @Test
    void testPowWithPositiveExponent() {
        assertEquals(8, calculator.calculate(2, 3, "pow"));
        assertEquals(100, calculator.calculate(10, 2, "pow"));
    }

    @Test
    void testPowLoop() {
        assertEquals(32, calculator.calculate(2, 5, "pow"));
    }

    @Test
    void testInvalidOperation() {
        assertEquals(0, calculator.calculate(10, 5, "invalid"));
    }

    @Test
    void testAddNumbers() {
        assertEquals(15, calculator.addNumbers(10, 5));
    }

    @Test
    void testSumValues() {
        assertEquals(15, calculator.sumValues(10, 5));
    }

    @Test
    void testAddAgainMethod() {
        assertEquals(15, calculator.addAgain(10, 5));
    }
}