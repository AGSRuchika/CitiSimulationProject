package com.example.profileapi.dto;

import java.util.List;

public class ProfileDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String skill;
    private String activity;
    private List<EducationDTO> education;
    private List<ExperienceDTO> experience;

    public ProfileDTO() {
    }

    @Override
	public String toString() {
		return "ProfileDTO [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", education=" + education + ", experience=" + experience + ", skills=" + skill
				+ ", activity=" + activity + "]";
	}

	public ProfileDTO(String name, String email, String phone, String address, List<EducationDTO> education, List<ExperienceDTO> experience, String skill, String activity) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.experience = experience;
        this.skill = skill;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    
    public List<EducationDTO> getEducation() {
        return education;
    }

    public void setEducation(List<EducationDTO> education) {
        this.education = education;
    }

    public List<ExperienceDTO> getExperience() {
        return experience;
    }

    public void setExperience(List<ExperienceDTO> experience) {
        this.experience = experience;
    }

}
