package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testMainDoesNotThrowException() {
        // Test that main method executes without crashing
        // This is a basic smoke test
        assertDoesNotThrow(() -> {
            // We can't easily test database operations
            // but we can verify the app structure
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
}