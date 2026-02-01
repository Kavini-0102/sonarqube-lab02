package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testCalculatorCreation() {
        Calculator calc = new Calculator();
        assertNotNull(calc);
        
        int result = calc.calculate(10, 5, "add-again");
        assertEquals(15, result);
    }

    @Test
    void testUserServiceCreation() {
        UserService service = new UserService();
        assertNotNull(service);
    }

    @Test
    void testAppComponentsWork() {
        Calculator calc = new Calculator();
        UserService service = new UserService();
        
        assertNotNull(calc);
        assertNotNull(service);
        
        // Test calculator functionality
        assertEquals(15, calc.calculate(10, 5, "add-again"));
        assertEquals(5, calc.calculate(10, 5, "sub"));
        assertEquals(50, calc.calculate(10, 5, "mul"));
    }
}