package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testMainMethodComponents() {
        // Simulate what main() does
        Calculator calc = new Calculator();
        UserService service = new UserService();
        
        assertNotNull(calc);
        assertNotNull(service);
        
        // Test the exact calculation from main
        int result = calc.calculate(10, 5, "add-again");
        assertEquals(15, result);
    }

    @Test
    void testCalculatorInstantiation() {
        Calculator calc = new Calculator();
        assertNotNull(calc);
        assertEquals(15, calc.calculate(10, 5, "add"));
    }

    @Test
    void testUserServiceInstantiation() {
        UserService service = new UserService();
        assertNotNull(service);
    }

    @Test
    void testMultipleCalculations() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.calculate(10, 5, "add-again"));
        assertEquals(5, calc.calculate(10, 5, "sub"));
        assertEquals(50, calc.calculate(10, 5, "mul"));
    }
}