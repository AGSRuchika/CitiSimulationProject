package com.example.profileapi.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.profileapi.dto.ProfileDTO;
import com.example.profileapi.response.ProfileResponse;
import com.example.profileapi.service.ProfileService;

@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {

    @Autowired
    private ProfileController profileController;

    @MockBean
    private ProfileService profileService;

    @MockBean
    private ProfileResponse profileResponse;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testCreateProfile_Success() {
        ProfileDTO inputProfileDTO = new ProfileDTO(); // Create a sample input DTO
        ProfileDTO createdProfileDTO = new ProfileDTO(); // Create a sample created DTO

        when(profileService.createProfile(inputProfileDTO)).thenReturn(createdProfileDTO);

        ResponseEntity<ProfileResponse> response = profileController.createProfile(inputProfileDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Profile created Successfully", response.getBody().getMessage());
        assertEquals(createdProfileDTO, response.getBody().getProfile());
    }

    @Test
    public void testGetProfileByEmail_Success() {
        String email = "testuser@gmail.com"; // Replace with an existing email address
        ProfileDTO existingProfileDTO = new ProfileDTO(); // Create a sample existing profile DTO

        when(profileService.getProfileByEmail(email)).thenReturn(existingProfileDTO);

        ResponseEntity<ProfileDTO> response = profileController.getProfileByEmail(email);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(existingProfileDTO, response.getBody());
    }

    @Test
    public void testGetProfileByEmail_NotFound() {
        String email = "nonexistentuser@gmail.com"; // Replace with a non-existing email address

        when(profileService.getProfileByEmail(email)).thenReturn(null);

        ResponseEntity<ProfileDTO> response = profileController.getProfileByEmail(email);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }


    @Test
    public void testDeleteProfileByEmail_Success() {
        String email = "testuser@gmail.com"; // Replace with an existing email address
        ProfileDTO deletedProfileDTO = new ProfileDTO(); // Create a sample deleted profile DTO

        when(profileService.deleteProfileByEmail(email)).thenReturn(deletedProfileDTO);

        ResponseEntity<ProfileDTO> response = profileController.deleteProfileByEmail(email);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(deletedProfileDTO, response.getBody());
    }

    @Test
    public void testDeleteProfileByEmail_NotFound() {
        String email = "nonexistentuser@gmail.com"; // Replace with a non-existing email address

        when(profileService.deleteProfileByEmail(email)).thenReturn(null);

        ResponseEntity<ProfileDTO> response = profileController.deleteProfileByEmail(email);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testGetAllProfiles_Success() {
        List<ProfileDTO> profiles = new ArrayList<>(); // Replace with a list of sample profiles

        when(profileService.getAllProfiles()).thenReturn(profiles);

        ResponseEntity<List<ProfileDTO>> response = profileController.getAllProfiles();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(profiles, response.getBody());
    }
}
