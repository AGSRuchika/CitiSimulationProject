package com.example.profileapi.dto;

public class ExperienceDTO {
    private String company;
    private String occupation;
    private String workFrom;
    private String workTo;
    private String jobDescription;

    public ExperienceDTO() {
    }

    public ExperienceDTO(String company, String occupation, String workFrom, String workTo, String jobDescription) {
        this.company = company;
        this.occupation = occupation;
        this.workFrom = workFrom;
        this.workTo = workTo;
        this.jobDescription = jobDescription;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkFrom() {
        return workFrom;
    }

    public void setWorkFrom(String workFrom) {
        this.workFrom = workFrom;
    }

    public String getWorkTo() {
        return workTo;
    }

    public void setWorkTo(String workTo) {
        this.workTo = workTo;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

	@Override
	public String toString() {
		return "ExperienceDTO [company=" + company + ", occupation=" + occupation + ", workFrom=" + workFrom
				+ ", workTo=" + workTo + ", jobDescription=" + jobDescription + "]";
	}

}
