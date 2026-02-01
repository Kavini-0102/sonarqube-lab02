package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testCalculatorInApp() {
        Calculator calc = new Calculator();
        int result = calc.calculate(10, 5, "add-again");
        assertEquals(15, result);
    }

    @Test
    void testUserServiceInApp() {
        UserService service = new UserService();
        assertNotNull(service);
    }

    @Test
    void testBothComponents() {
        Calculator calc = new Calculator();
        UserService service = new UserService();
        
        assertNotNull(calc);
        assertNotNull(service);
        assertEquals(15, calc.calculate(10, 5, "add-again"));
    }
}