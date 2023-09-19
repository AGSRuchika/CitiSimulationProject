package com.example.profileapi.constants;

import org.springframework.http.HttpStatus;

public class Constants {
	public static final String ALLOWED_ORIGIN = "http://localhost:4200";
    public static final String[] ALLOWED_METHODS = {"GET", "POST", "PUT", "DELETE", "PATCH"};
    public static final String API_PROFILES = "/api/profiles";
    public static final String API_PROFILE_BY_ID = "/{id}";
    public static final String API_PROFILE_BY_EMAIL = "/byemail/{email}";
    public static final String API_PROFILE_BY_NAME = "/byname/{name}";
    public static final String API_PROFILE_NAMES = "/name";
    public static final String API_PROFILE_EMAILS = "/email";
    public static final String API_PROFILE_DELETE_BY_EMAIL = "/delete/{email}";
    public static final String API_PROFILE_ALL = "/all";
    public static final String CREATE_SUCCESS="Profile created Successfully";
    public static final String PROFILE_ALREADY_EXISTS_EXCEPTION = "ProfileAlreadyExistsException";
    public static final String NUMBER_OF_PROFILES_EXCEEDS_TEN = "NumberOfProfilesExceedsTen";
    public static final HttpStatus HTTP_STATUS_BAD_REQUEST = HttpStatus.BAD_REQUEST;
    public static final HttpStatus HTTP_STATUS_TOO_MANY_REQUESTS = HttpStatus.TOO_MANY_REQUESTS;
    public static final int MAX_PROFILES = 10;
    public static final String EXCEEDS_TEN="Cannot create more than 10 profiles";
    public static final String PROFILEEXISTS="Profile already exists, Cannot create another profile";
}