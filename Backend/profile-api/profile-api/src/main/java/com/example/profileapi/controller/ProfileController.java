package com.example.profileapi.controller;

import com.example.profileapi.dto.ProfileDTO;
import com.example.profileapi.constants.Constants;
import com.example.profileapi.response.ProfileResponse;
import com.example.profileapi.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(Constants.API_PROFILES)
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileResponse profileResponse;

    @PostMapping
    public ResponseEntity<ProfileResponse> createProfile(@RequestBody ProfileDTO profileDTO) {
        ProfileDTO createdProfile = profileService.createProfile(profileDTO);
        profileResponse.setMessage(Constants.CREATE_SUCCESS);
        profileResponse.setProfile(createdProfile);
        return new ResponseEntity<>(profileResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = Constants.API_PROFILE_BY_EMAIL)
    public ResponseEntity<ProfileDTO> getProfileByEmail(@PathVariable String email) {
        ProfileDTO profile = profileService.getProfileByEmail(email);
        if (profile != null) {
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = Constants.API_PROFILE_DELETE_BY_EMAIL)
    public ResponseEntity<ProfileDTO> deleteProfileByEmail(@PathVariable String email) {
        ProfileDTO deletedProfile = profileService.deleteProfileByEmail(email);
        if (deletedProfile != null) {
            return new ResponseEntity<>(deletedProfile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(Constants.API_PROFILE_ALL)
    public ResponseEntity<List<ProfileDTO>> getAllProfiles() {
        List<ProfileDTO> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
}
