package com.example.profileapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.profileapi.constants.Constants;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ProfileAlreadyExistsException.class)
    public ResponseEntity<Object> handleProfileAlreadyExistsException(ProfileAlreadyExistsException e) {
        ExceptionMessage message = new ExceptionMessage();
        message.setType(Constants.PROFILE_ALREADY_EXISTS_EXCEPTION);
        message.setHttpStatus(Constants.HTTP_STATUS_BAD_REQUEST);
        message.setMessage(e.getMessage());
        return new ResponseEntity<>(message, Constants.HTTP_STATUS_BAD_REQUEST);
    }

    @ExceptionHandler(NumberOfProfilesExceedsTen.class)
    public ResponseEntity<Object> handleNumberOfProfilesExceedsTen(NumberOfProfilesExceedsTen e) {
        ExceptionMessage message = new ExceptionMessage();
        message.setType(Constants.NUMBER_OF_PROFILES_EXCEEDS_TEN);
        message.setHttpStatus(Constants.HTTP_STATUS_TOO_MANY_REQUESTS);
        message.setMessage(e.getMessage());
        return new ResponseEntity<>(message, Constants.HTTP_STATUS_TOO_MANY_REQUESTS);
    }
}
