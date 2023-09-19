package com.example.profileapi.dto;

public class EducationDTO {
    private String college;
    private String studyFrom;
    private String studyTo;
    private String department;
    private String percentage;

    public EducationDTO() {
    }

    public EducationDTO(String college, String studyFrom, String studyTo, String department, String percentage) {
        this.college = college;
        this.studyFrom = studyFrom;
        this.studyTo = studyTo;
        this.department = department;
        this.percentage = percentage;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getStudyFrom() {
        return studyFrom;
    }

    public void setStudyFrom(String studyFrom) {
        this.studyFrom = studyFrom;
    }

    public String getStudyTo() {
        return studyTo;
    }

    public void setStudyTo(String studyTo) {
        this.studyTo = studyTo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

	@Override
	public String toString() {
		return "EducationDTO [college=" + college + ", studyFrom=" + studyFrom + ", studyTo=" + studyTo
				+ ", department=" + department + ", percentage=" + percentage + "]";
	}

}
