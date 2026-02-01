package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testMainDoesNotThrowException() {
        assertDoesNotThrow(() -> {
            Calculator calc = new Calculator();
            assertNotNull(calc);
            
            UserService service = new UserService();
            assertNotNull(service);
        });
    }

    @Test
    void testCalculatorUsedInApp() {
        Calculator calc = new Calculator();
        int result = calc.calculate(10, 5, "add-again");
        assertEquals(15, result);
    }

    @Test
    void testAppComponents() {
        // Test that App can create its components
        Calculator calc = new Calculator();
        UserService service = new UserService();
        
        assertNotNull(calc);
        assertNotNull(service);
        
        // Test calculator works as expected
        assertEquals(15, calc.calculate(10, 5, "add-again"));
    }
}