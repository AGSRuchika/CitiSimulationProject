package com.example.profileapi.service.impl;

import com.example.profileapi.dto.ExperienceDTO;
import com.example.profileapi.repository.ExperienceRepository;
import com.example.profileapi.service.ExperienceService;
import com.example.profileapi.entity.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    
    private final ExperienceRepository experienceRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository, ModelMapper modelMapper) {
        this.experienceRepository = experienceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ExperienceDTO save(ExperienceDTO experienceDTO) {
        Experience experience = modelMapper.map(experienceDTO, Experience.class);
        Experience savedExperience = experienceRepository.save(experience);
        return modelMapper.map(savedExperience, ExperienceDTO.class);
    }
}

