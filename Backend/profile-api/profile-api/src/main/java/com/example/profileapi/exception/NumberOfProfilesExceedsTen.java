package com.example.profileapi.exception;

public class NumberOfProfilesExceedsTen extends RuntimeException {
	public NumberOfProfilesExceedsTen(String message) {
		super(message);
	}

}
