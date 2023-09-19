package com.example.profileapi.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppExceptionHandlerTest {

    @Test
    public void testHandleProfileAlreadyExistsException() {
        AppExceptionHandler handler = new AppExceptionHandler();
        ProfileAlreadyExistsException exception = new ProfileAlreadyExistsException("Profile already exists");

        ResponseEntity<Object> response = handler.handleProfileAlreadyExistsException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        ExceptionMessage message = (ExceptionMessage) response.getBody();
        assertEquals("ProfileAlreadyExistsException", message.getType());
        assertEquals("Profile already exists", message.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, message.getHttpStatus());
    }

    @Test
    public void testHandleNumberOfProfilesExceedsTen() {
        AppExceptionHandler handler = new AppExceptionHandler();
        NumberOfProfilesExceedsTen exception = new NumberOfProfilesExceedsTen("Too many profiles");

        ResponseEntity<Object> response = handler.handleNumberOfProfilesExceedsTen(exception);

        assertEquals(HttpStatus.TOO_MANY_REQUESTS, response.getStatusCode());
        ExceptionMessage message = (ExceptionMessage) response.getBody();
        assertEquals("NumberOfProfilesExceedsTen", message.getType());
        assertEquals("Too many profiles", message.getMessage());
        assertEquals(HttpStatus.TOO_MANY_REQUESTS, message.getHttpStatus());
    }
}
