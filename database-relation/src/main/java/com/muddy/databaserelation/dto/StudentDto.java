package com.muddy.databaserelation.dto;

public class StudentDto {
    private String studentFname;
    private String studentLname;
    private String studentEmail;
    private GuardianDto guardianDto;

    public StudentDto() {
    }

    public StudentDto(String studentFname, String studentLname, String studentEmail, GuardianDto guardianDto) {
        this.studentFname = studentFname;
        this.studentLname = studentLname;
        this.studentEmail = studentEmail;
        this.guardianDto = guardianDto;
    }

    public String getStudentFname() {
        return studentFname;
    }

    public void setStudentFname(String studentFname) {
        this.studentFname = studentFname;
    }

    public String getStudentLname() {
        return studentLname;
    }

    public void setStudentLname(String studentLname) {
        this.studentLname = studentLname;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public GuardianDto getGuardianDto() {
        return guardianDto;
    }

    public void setGuardianDto(GuardianDto guardianDto) {
        this.guardianDto = guardianDto;
    }
}
