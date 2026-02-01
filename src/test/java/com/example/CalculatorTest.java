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
    void testDivisionByZeroInElse() {
        // Test the else branch where b != 0
        assertEquals(3, calculator.calculate(9, 3, "div"));
    }

    @Test
    void testModulo() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
        assertEquals(0, calculator.calculate(10, 5, "mod"));
        assertEquals(2, calculator.calculate(7, 5, "mod"));
    }

    @Test
    void testPower() {
        assertEquals(100, calculator.calculate(10, 2, "pow"));
        assertEquals(8, calculator.calculate(2, 3, "pow"));
        assertEquals(1, calculator.calculate(5, 0, "pow"));
        assertEquals(27, calculator.calculate(3, 3, "pow"));
    }

    @Test
    void testPowerLoopCoverage() {
        // Test multiple iterations of power loop
        assertEquals(16, calculator.calculate(2, 4, "pow"));
        assertEquals(32, calculator.calculate(2, 5, "pow"));
    }

    @Test
    void testInvalidOperation() {
        assertEquals(0, calculator.calculate(10, 5, "invalid"));
        assertEquals(0, calculator.calculate(10, 5, "xyz"));
        assertEquals(0, calculator.calculate(10, 5, "test"));
    }

    @Test
    void testAddNumbers() {
        assertEquals(15, calculator.addNumbers(10, 5));
        assertEquals(0, calculator.addNumbers(0, 0));
        assertEquals(-5, calculator.addNumbers(-10, 5));
        assertEquals(100, calculator.addNumbers(50, 50));
    }

    @Test
    void testSumValues() {
        assertEquals(15, calculator.sumValues(10, 5));
        assertEquals(0, calculator.sumValues(0, 0));
        assertEquals(-5, calculator.sumValues(-10, 5));
        assertEquals(100, calculator.sumValues(50, 50));
    }

    @Test
    void testAddAgainMethod() {
        assertEquals(15, calculator.addAgain(10, 5));
        assertEquals(0, calculator.addAgain(0, 0));
        assertEquals(-5, calculator.addAgain(-10, 5));
        assertEquals(100, calculator.addAgain(50, 50));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-15, calculator.calculate(-10, -5, "add"));
        assertEquals(-5, calculator.calculate(-10, -5, "sub"));
        assertEquals(50, calculator.calculate(-10, -5, "mul"));
    }

    @Test
    void testAllIfBranches() {
        // Cover all if-else branches thoroughly
        calculator.calculate(5, 3, "add");
        calculator.calculate(5, 3, "add-again");
        calculator.calculate(5, 3, "sub");
        calculator.calculate(5, 3, "sub-again");
        calculator.calculate(5, 3, "mul");
        calculator.calculate(6, 2, "div");
        calculator.calculate(5, 0, "div");  // Division by zero branch
        calculator.calculate(5, 3, "mod");
        calculator.calculate(2, 3, "pow");
        calculator.calculate(5, 3, "unknown");
    }

    @Test
    void testEdgeCases() {
        assertEquals(0, calculator.calculate(0, 0, "add"));
        assertEquals(0, calculator.calculate(0, 0, "mul"));
        assertEquals(1, calculator.calculate(0, 0, "pow"));
        assertEquals(0, calculator.calculate(0, 5, "div"));
    }
}