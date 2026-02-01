package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.calculate(10, 5, "add"));
    }

    @Test
    void testAddAgain() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.calculate(10, 5, "add-again"));
    }

    @Test
    void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.calculate(10, 5, "sub"));
    }

    @Test
    void testSubAgain() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.calculate(10, 5, "sub-again"));
    }

    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        assertEquals(50, calc.calculate(10, 5, "mul"));
    }

    @Test
    void testDivision() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.calculate(10, 5, "div"));
    }

    @Test
    void testDivisionByZero() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.calculate(10, 0, "div"));
    }

    @Test
    void testModulo() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.calculate(10, 3, "mod"));
    }

    @Test
    void testPower() {
        Calculator calc = new Calculator();
        assertEquals(100, calc.calculate(10, 2, "pow"));
    }

    @Test
    void testInvalidOperation() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.calculate(10, 5, "invalid"));
    }

    @Test
    void testAddNumbers() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.addNumbers(10, 5));
    }

    @Test
    void testSumValues() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.sumValues(10, 5));
    }

    @Test
    void testAddAgainMethod() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.addAgain(10, 5));
    }
}