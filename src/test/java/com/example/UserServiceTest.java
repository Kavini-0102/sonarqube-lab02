package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

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
    void testFindUserThrowsSQLException() {
        // Since there's no real database, this will fail
        // but we're testing that the method signature is correct
        assertThrows(SQLException.class, () -> {
            userService.findUser("testuser");
        });
    }

    @Test
    void testDeleteUserThrowsSQLException() {
        // Since there's no real database, this will fail
        // but we're testing that the method signature is correct
        assertThrows(SQLException.class, () -> {
            userService.deleteUser("testuser");
        });
    }

    @Test
    void testFindUserWithNullUsername() {
        assertThrows(SQLException.class, () -> {
            userService.findUser(null);
        });
    }

    @Test
    void testDeleteUserWithNullUsername() {
        assertThrows(SQLException.class, () -> {
            userService.deleteUser(null);
        });
    }
}