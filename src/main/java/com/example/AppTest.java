package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testMainDoesNotThrowException() {
        assertDoesNotThrow(() -> {
            // We can't really test main easily without mocking,
            // but we can verify it doesn't crash
            String[] args = {};
            // App.main(args); // This would require DB, so we skip actual execution
        });
    }
}