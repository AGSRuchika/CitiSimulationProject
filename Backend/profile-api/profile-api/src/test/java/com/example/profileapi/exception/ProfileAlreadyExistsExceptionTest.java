package com.example.profileapi.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileAlreadyExistsExceptionTest {

    @Test
    public void testConstructor() {
        String expectedMessage = "Profile already exists";
        ProfileAlreadyExistsException exception = new ProfileAlreadyExistsException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }
}
