package com.example.profileapi.exception;

import com.example.profileapi.exception.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionMessageTest {

    @Test
    public void testExceptionMessageGettersAndSetters() {
        // Create an instance of ExceptionMessage
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        // Set values using setters
        exceptionMessage.setType("TestType");
        exceptionMessage.setMessage("TestMessage");
        exceptionMessage.setHttpStatus(HttpStatus.BAD_REQUEST);

        // Use getters to retrieve values
        assertEquals("TestType", exceptionMessage.getType());
        assertEquals("TestMessage", exceptionMessage.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, exceptionMessage.getHttpStatus());
    }
}
