package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static final String OP_ADD = "add";
    private static final String OP_ADD_AGAIN = "add-again";
    private static final String OP_SUB = "sub";
    private static final String OP_SUB_AGAIN = "sub-again";
    private static final String OP_MUL = "mul";
    private static final String OP_DIV = "div";
    private static final String OP_MOD = "mod";
    private static final String OP_POW = "pow";
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @ParameterizedTest
    @CsvSource({
        "10, 5, add, 15",
        "10, 5, sub, 5",
        "10, 5, mul, 50",
        "10, 5, div, 2",
        "10, 3, mod, 1",
        "2, 3, pow, 8",
        "0, 5, add, 5",
        "-10, 5, add, -5",
        "10, 5, add-again, 15",
        "10, 5, sub-again, 5"
    })
    void testCalculateWithValidOperations(int a, int b, String operation, int expected) {
        assertEquals(expected, calculator.calculate(a, b, operation));
    }

    @Test
    void testAdd() {
        assertEquals(15, calculator.calculate(10, 5, OP_ADD));
        assertEquals(0, calculator.calculate(0, 0, OP_ADD));
        assertEquals(-5, calculator.calculate(-10, 5, OP_ADD));
    }

    @Test
    void testAddAgain() {
        assertEquals(15, calculator.calculate(10, 5, OP_ADD_AGAIN));
        assertEquals(100, calculator.calculate(50, 50, OP_ADD_AGAIN));
    }

    @Test
    void testSub() {
        assertEquals(5, calculator.calculate(10, 5, OP_SUB));
        assertEquals(0, calculator.calculate(5, 5, OP_SUB));
        assertEquals(-15, calculator.calculate(-10, 5, OP_SUB));
    }

    @Test
    void testSubAgain() {
        assertEquals(5, calculator.calculate(10, 5, OP_SUB_AGAIN));
        assertEquals(-5, calculator.calculate(0, 5, OP_SUB_AGAIN));
    }

    @Test
    void testMul() {
        assertEquals(50, calculator.calculate(10, 5, OP_MUL));
        assertEquals(0, calculator.calculate(0, 5, OP_MUL));
        assertEquals(-50, calculator.calculate(-10, 5, OP_MUL));
    }

    @Test
    void testDivWhenBIsZero() {
        assertEquals(0, calculator.calculate(10, 0, OP_DIV));
        assertEquals(0, calculator.calculate(100, 0, OP_DIV));
    }

    @Test
    void testDivWhenBIsNotZero() {
        assertEquals(2, calculator.calculate(10, 5, OP_DIV));
        assertEquals(5, calculator.calculate(10, 2, OP_DIV));
        assertEquals(3, calculator.calculate(9, 3, OP_DIV));
    }

    @Test
    void testMod() {
        assertEquals(1, calculator.calculate(10, 3, OP_MOD));
        assertEquals(0, calculator.calculate(10, 5, OP_MOD));
        assertEquals(2, calculator.calculate(7, 5, OP_MOD));
    }

    @Test
    void testPowWithZeroExponent() {
        assertEquals(1, calculator.calculate(5, 0, OP_POW));
        assertEquals(1, calculator.calculate(100, 0, OP_POW));
    }

    @Test
    void testPowWithOneIteration() {
        assertEquals(5, calculator.calculate(5, 1, OP_POW));
        assertEquals(10, calculator.calculate(10, 1, OP_POW));
    }

    @Test
    void testPowWithMultipleIterations() {
        assertEquals(8, calculator.calculate(2, 3, OP_POW));
        assertEquals(16, calculator.calculate(2, 4, OP_POW));
        assertEquals(32, calculator.calculate(2, 5, OP_POW));
        assertEquals(100, calculator.calculate(10, 2, OP_POW));
        assertEquals(27, calculator.calculate(3, 3, OP_POW));
    }

    @Test
    void testInvalidOperation() {
        assertEquals(0, calculator.calculate(10, 5, "invalid"));
        assertEquals(0, calculator.calculate(10, 5, "xyz"));
        assertEquals(0, calculator.calculate(10, 5, ""));
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
        assertEquals(-10, calculator.sumValues(-5, -5));
        assertEquals(25, calculator.sumValues(20, 5));
    }

    @Test
    void testAddAgainMethod() {
        assertEquals(15, calculator.addAgain(10, 5));
        assertEquals(7, calculator.addAgain(3, 4));
        assertEquals(-5, calculator.addAgain(-10, 5));
    }

    @Test
    void testAllBranchesCovered() {
        calculator.calculate(1, 1, OP_ADD);
        calculator.calculate(1, 1, OP_ADD_AGAIN);
        calculator.calculate(1, 1, OP_SUB);
        calculator.calculate(1, 1, OP_SUB_AGAIN);
        calculator.calculate(1, 1, OP_MUL);
        calculator.calculate(1, 0, OP_DIV);
        calculator.calculate(1, 1, OP_DIV);
        calculator.calculate(1, 1, OP_MOD);
        calculator.calculate(1, 0, OP_POW);
        calculator.calculate(2, 5, OP_POW);
        calculator.calculate(1, 1, "other");
        
        assertEquals(2, calculator.calculate(1, 1, OP_ADD));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-15, calculator.calculate(-10, -5, OP_ADD));
        assertEquals(-5, calculator.calculate(-10, -5, OP_SUB));
        assertEquals(50, calculator.calculate(-10, -5, OP_MUL));
        assertEquals(2, calculator.calculate(-10, -5, OP_DIV));
    }

    @Test
    void testLargeNumbers() {
        assertEquals(1000, calculator.calculate(500, 500, OP_ADD));
        assertEquals(10000, calculator.calculate(100, 100, OP_MUL));
    }

    @Test
    void testEdgeCases() {
        assertEquals(0, calculator.calculate(0, 0, OP_MUL));
        assertEquals(1, calculator.calculate(1, 1, OP_DIV));
        assertEquals(5, calculator.calculate(5, 7, OP_MOD));
    }
    
    @ParameterizedTest
    @CsvSource({
        "100, 50, add, 150",
        "100, 50, sub, 50",
        "100, 50, mul, 5000",
        "100, 50, div, 2"
    })
    void testWithLargerNumbers(int a, int b, String operation, int expected) {
        assertEquals(expected, calculator.calculate(a, b, operation));
    }
    
    @Test
    void testDivisionEdgeCases() {
        assertEquals(0, calculator.calculate(5, 0, OP_DIV));
        assertEquals(10, calculator.calculate(100, 10, OP_DIV));
    }
    
    @Test
    void testModulusEdgeCases() {
        assertEquals(0, calculator.calculate(10, 1, OP_MOD));
        assertEquals(3, calculator.calculate(10, 7, OP_MOD));
    }
    
    @Test
    void testPowerEdgeCases() {
        assertEquals(1024, calculator.calculate(2, 10, OP_POW));
        assertEquals(1, calculator.calculate(999, 0, OP_POW));
    }
}