package com.example.profileapi.service.impl;

import com.example.profileapi.dto.EducationDTO;
import com.example.profileapi.repository.EducationRepository;
import com.example.profileapi.service.EducationService;
import com.example.profileapi.entity.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository, ModelMapper modelMapper) {
        this.educationRepository = educationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EducationDTO save(EducationDTO educationDTO) {
        Education education = modelMapper.map(educationDTO, Education.class);
        Education savedEducation = educationRepository.save(education);
        return modelMapper.map(savedEducation, EducationDTO.class);
    }

}

