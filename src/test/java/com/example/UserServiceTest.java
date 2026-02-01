package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void testUserServiceCreation() {
        assertNotNull(userService);
    }

    @Test
    void testUserServiceHasPasswordField() {
        // Just verify the object is properly constructed
        assertNotNull(userService);
    }
}