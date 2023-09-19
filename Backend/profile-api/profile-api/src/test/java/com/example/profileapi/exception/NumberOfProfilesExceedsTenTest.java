package com.example.profileapi.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfProfilesExceedsTenTest {

    @Test
    public void testConstructor() {
        String expectedMessage = "Too many profiles";
        NumberOfProfilesExceedsTen exception = new NumberOfProfilesExceedsTen(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }
}
