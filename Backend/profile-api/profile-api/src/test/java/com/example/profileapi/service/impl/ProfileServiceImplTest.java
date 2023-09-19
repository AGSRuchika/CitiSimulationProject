package com.example.profileapi.service.impl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.profileapi.dto.EducationDTO;
import com.example.profileapi.dto.ExperienceDTO;
import com.example.profileapi.dto.ProfileDTO;
import com.example.profileapi.entity.Education;
import com.example.profileapi.entity.Experience;
import com.example.profileapi.entity.Profile;
import com.example.profileapi.exception.NumberOfProfilesExceedsTen;
import com.example.profileapi.exception.ProfileAlreadyExistsException;
import com.example.profileapi.repository.ProfileRepository;

@WebMvcTest(ProfileServiceImpl.class)
public class ProfileServiceImplTest {

    @MockBean
    private ProfileRepository profileRepository;

    @MockBean
    private ModelMapper modelMapper;

    private ProfileServiceImpl profileService;

    @BeforeEach
    public void setUp() {
        profileService = new ProfileServiceImpl(profileRepository, modelMapper);
    }

    @Test
    public void testCreateProfile_Success() {
        // Create a ProfileDTO with valid education data
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setEmail("test@example.com");
        // Initialize the education field with a non-null List
        List<EducationDTO> educationList = new ArrayList<>();
        // Add education data to the list as needed
        educationList.add(new EducationDTO()); // Add an EducationDTO object
        profileDTO.setEducation(educationList);
        when(profileRepository.findByEmail(profileDTO.getEmail())).thenReturn(null);
        when(modelMapper.map(profileDTO, Profile.class)).thenReturn(new Profile());
        when(profileRepository.save(any(Profile.class))).thenReturn(new Profile());
        ProfileDTO result = profileService.createProfile(profileDTO);
        assertNotNull(result);
    }

    @Test
    public void testCreateProfile_ExistingProfile() {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setEmail("existinguser@gmail.com");
        when(profileRepository.findByEmail(profileDTO.getEmail())).thenReturn(new Profile());
        assertThrows(ProfileAlreadyExistsException.class, () -> profileService.createProfile(profileDTO));
    }

    @Test
    public void testDeleteProfileByEmail_Success() {
        String email = "testuser@gmail.com";
        Profile expectedProfileEntity = new Profile();
        when(profileRepository.findByEmail(email)).thenReturn(expectedProfileEntity);
        ProfileDTO result = profileService.deleteProfileByEmail(email);
        assertNotNull(result);
    }

    @Test
    public void testDeleteProfileByEmail_NonExistingProfile() {
        String email = "nonexistentuser@gmail.com";
        when(profileRepository.findByEmail(email)).thenReturn(null);
        ProfileDTO result = profileService.deleteProfileByEmail(email);
        assertNull(result);
    }

    @Test
    public void testGetAllProfiles_NotEmpty() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile());
        profiles.add(new Profile());
        when(profileRepository.findAll()).thenReturn(profiles);
        when(modelMapper.map(any(Profile.class), eq(ProfileDTO.class))).thenReturn(new ProfileDTO());
        List<ProfileDTO> result = profileService.getAllProfiles();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllProfiles_Empty() {
        List<Profile> profiles = new ArrayList<>();
        when(profileRepository.findAll()).thenReturn(profiles);
        List<ProfileDTO> result = profileService.getAllProfiles();
        assertEquals(0, result.size());
    }

    @Test
    public void testGetProfileByEmail_ExistingProfile() {
        String email = "testuser@gmail.com";
        ProfileDTO expectedProfileDTO = new ProfileDTO();
        Profile expectedProfileEntity = new Profile();
        when(profileRepository.findByEmail(email)).thenReturn(expectedProfileEntity);
        when(modelMapper.map(expectedProfileEntity, ProfileDTO.class)).thenReturn(expectedProfileDTO);
        ProfileDTO result = profileService.getProfileByEmail(email);
        assertEquals(expectedProfileDTO, result);
    }

    @Test
    public void testGetProfileByEmail_NonExistingProfile() {
        String email = "nonexistentuser@gmail.com";
        when(profileRepository.findByEmail(email)).thenReturn(null);
        ProfileDTO result = profileService.getProfileByEmail(email);
        assertNull(result);
    }
    
    @Test
    public void testGetAllProfileNames_NotEmpty() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile());
        profiles.add(new Profile());

        when(profileRepository.findAll()).thenReturn(profiles);

        List<String> result = profileService.getAllProfileNames();

        assertEquals(2, result.size());
    }   
    @Test
    public void testGetAllProfileNames_Empty() {
        List<Profile> profiles = new ArrayList<>();

        when(profileRepository.findAll()).thenReturn(profiles);

        List<String> result = profileService.getAllProfileNames();

        assertEquals(0, result.size());
    }
}
