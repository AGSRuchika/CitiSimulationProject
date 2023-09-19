package com.example.profileapi.service.impl;

import com.example.profileapi.dto.EducationDTO;
import com.example.profileapi.constants.Constants;
import com.example.profileapi.dto.ExperienceDTO;
import com.example.profileapi.dto.ProfileDTO;
import com.example.profileapi.repository.ProfileRepository;
import com.example.profileapi.service.ProfileService;
import com.example.profileapi.entity.Education;
import com.example.profileapi.entity.Experience;
import com.example.profileapi.entity.Profile;
import com.example.profileapi.exception.NumberOfProfilesExceedsTen;
import com.example.profileapi.exception.ProfileAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.Optional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {
	
    private final ProfileRepository profileRepository;
    private final ModelMapper modelMapper;
    

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository, ModelMapper modelMapper) {
        this.profileRepository = profileRepository;
        this.modelMapper = modelMapper;
        count = getAllProfileNames().size();
    }
    
    private static int count = 0;

    @Override
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        if (count >= Constants.MAX_PROFILES) {
            throw new NumberOfProfilesExceedsTen(Constants.EXCEEDS_TEN);
        }

        String email = profileDTO.getEmail();
        Profile findProfile = profileRepository.findByEmail(email);
        if (findProfile == null) {
            Profile profile = modelMapper.map(profileDTO, Profile.class);

            for (EducationDTO educationDTO : profileDTO.getEducation()) {
                Education education = modelMapper.map(educationDTO, Education.class);
                education.setProfile(profile);
                profile.getEducationList().add(education);
            }

            for (ExperienceDTO experienceDTO : profileDTO.getExperience()) {
                Experience experience = modelMapper.map(experienceDTO, Experience.class);
                experience.setProfile(profile);
                profile.getExperienceList().add(experience);
            }

            Profile createdProfile = profileRepository.save(profile);
            count = count + 1;
            System.out.println(count);
            return modelMapper.map(createdProfile, ProfileDTO.class);
        } else {
            throw new ProfileAlreadyExistsException(Constants.PROFILEEXISTS);
        }
    }
  
    public ProfileDTO getProfileByEmail(String email) {
        Profile profile = profileRepository.findByEmail(email);

        if (profile != null) {
        	ProfileDTO profileDTO = modelMapper.map(profile, ProfileDTO.class);

            return profileDTO;
        } else {
            return null; 
        }
    }
    
    @Override
    public ProfileDTO deleteProfileByEmail(String email) {
        Profile profile = profileRepository.findByEmail(email);

        if (profile != null) {
            profileRepository.delete(profile);
            count=count-1;
            return modelMapper.map(profile, ProfileDTO.class);
        } else {
            return null;
        }
    }
    
    @Override
    public List<String> getAllProfileNames() {
        List<Profile> profiles = profileRepository.findAll();
        if (!profiles.isEmpty()) {
            List<String> profileNames = profiles.stream()
                    .map(Profile::getName)
                    .collect(Collectors.toList());
            count = profileNames.size();
            return profileNames;
        } else {
            count = 0;
            return new ArrayList<>();
        }
    }
    
    public List<ProfileDTO> getAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();
        
        return profiles.stream()
                .map(profile -> modelMapper.map(profile, ProfileDTO.class))
                .collect(Collectors.toList());
    }
    
    public static int getCount() {
        return count;
    }
}
