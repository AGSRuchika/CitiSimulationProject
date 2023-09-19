package com.example.profileapi.service;

import com.example.profileapi.dto.ProfileDTO;

import java.util.List;
import java.util.Set;

public interface ProfileService {
	ProfileDTO createProfile(ProfileDTO profileDTO);
	ProfileDTO getProfileByEmail(String email);
	List<String> getAllProfileNames();
	ProfileDTO deleteProfileByEmail(String email);
	List<ProfileDTO> getAllProfiles();
}
