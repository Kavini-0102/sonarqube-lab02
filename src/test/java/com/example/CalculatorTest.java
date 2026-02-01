package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.calculate(10, 5, "add"));
        assertEquals(0, calc.calculate(0, 0, "add"));
        assertEquals(-5, calc.calculate(-10, 5, "add"));
    }

    @Test
    void testAddAgain() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.calculate(10, 5, "add-again"));
        assertEquals(100, calc.calculate(50, 50, "add-again"));
    }

    @Test
    void testSub() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.calculate(10, 5, "sub"));
        assertEquals(0, calc.calculate(5, 5, "sub"));
        assertEquals(-15, calc.calculate(-10, 5, "sub"));
    }

    @Test
    void testSubAgain() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.calculate(10, 5, "sub-again"));
        assertEquals(0, calc.calculate(5, 5, "sub-again"));
    }

    @Test
    void testMul() {
        Calculator calc = new Calculator();
        assertEquals(50, calc.calculate(10, 5, "mul"));
        assertEquals(0, calc.calculate(0, 5, "mul"));
        assertEquals(-50, calc.calculate(-10, 5, "mul"));
    }

    @Test
    void testDivWhenBIsZero() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.calculate(10, 0, "div"));
        assertEquals(0, calc.calculate(100, 0, "div"));
    }

    @Test
    void testDivWhenBIsNotZero() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.calculate(10, 5, "div"));
        assertEquals(5, calc.calculate(10, 2, "div"));
        assertEquals(3, calc.calculate(9, 3, "div"));
    }

    @Test
    void testMod() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.calculate(10, 3, "mod"));
        assertEquals(0, calc.calculate(10, 5, "mod"));
        assertEquals(2, calc.calculate(7, 5, "mod"));
    }

    @Test
    void testPowWithZeroExponent() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.calculate(5, 0, "pow"));
        assertEquals(1, calc.calculate(100, 0, "pow"));
    }

    @Test
    void testPowWithOneIteration() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.calculate(5, 1, "pow"));
        assertEquals(10, calc.calculate(10, 1, "pow"));
    }

    @Test
    void testPowWithMultipleIterations() {
        Calculator calc = new Calculator();
        assertEquals(8, calc.calculate(2, 3, "pow"));
        assertEquals(16, calc.calculate(2, 4, "pow"));
        assertEquals(32, calc.calculate(2, 5, "pow"));
        assertEquals(100, calc.calculate(10, 2, "pow"));
        assertEquals(27, calc.calculate(3, 3, "pow"));
    }

    @Test
    void testInvalidOperation() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.calculate(10, 5, "invalid"));
        assertEquals(0, calc.calculate(10, 5, "xyz"));
        assertEquals(0, calc.calculate(10, 5, ""));
    }

    @Test
    void testAddNumbers() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.addNumbers(10, 5));
        assertEquals(0, calc.addNumbers(0, 0));
        assertEquals(-5, calc.addNumbers(-10, 5));
        assertEquals(100, calc.addNumbers(50, 50));
    }

    @Test
    void testSumValues() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.sumValues(10, 5));
        assertEquals(0, calc.sumValues(0, 0));
        assertEquals(-5, calc.sumValues(-10, 5));
        assertEquals(100, calc.sumValues(50, 50));
    }

    @Test
    void testAddAgainMethod() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.addAgain(10, 5));
        assertEquals(0, calc.addAgain(0, 0));
        assertEquals(-5, calc.addAgain(-10, 5));
        assertEquals(100, calc.addAgain(50, 50));
    }

    @Test
    void testAllBranchesCovered() {
        Calculator calc = new Calculator();
        
        // Ensure every if-else branch is executed
        calc.calculate(1, 1, "add");
        calc.calculate(1, 1, "add-again");
        calc.calculate(1, 1, "sub");
        calc.calculate(1, 1, "sub-again");
        calc.calculate(1, 1, "mul");
        calc.calculate(1, 0, "div"); // if (b == 0)
        calc.calculate(1, 1, "div"); // else
        calc.calculate(1, 1, "mod");
        calc.calculate(1, 0, "pow"); // power with 0
        calc.calculate(2, 5, "pow"); // power loop
        calc.calculate(1, 1, "other"); // else branch
        
        // Verify at least one
        assertEquals(2, calc.calculate(1, 1, "add"));
    }

    @Test
    void testNegativeNumbers() {
        Calculator calc = new Calculator();
        assertEquals(-15, calc.calculate(-10, -5, "add"));
        assertEquals(-5, calc.calculate(-10, -5, "sub"));
        assertEquals(50, calc.calculate(-10, -5, "mul"));
        assertEquals(2, calc.calculate(-10, -5, "div"));
    }

    @Test
    void testLargeNumbers() {
        Calculator calc = new Calculator();
        assertEquals(1000, calc.calculate(500, 500, "add"));
        assertEquals(10000, calc.calculate(100, 100, "mul"));
    }
}