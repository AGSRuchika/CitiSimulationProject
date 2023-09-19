package com.example.profileapi.response;

import org.springframework.stereotype.Component;

import com.example.profileapi.dto.ProfileDTO;

@Component
public class ProfileResponse {
    private String message;
    private ProfileDTO profile;

    public ProfileResponse(String message, ProfileDTO profile) {
        this.message = message;
        this.profile = profile;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ProfileDTO getProfile() {
		return profile;
	}

	public void setProfile(ProfileDTO profile) {
		this.profile = profile;
	}

	public ProfileResponse() {
		super();
	}
	
}
