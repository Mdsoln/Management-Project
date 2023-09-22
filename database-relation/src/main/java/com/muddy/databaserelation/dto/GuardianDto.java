package com.muddy.databaserelation.dto;


import com.muddy.databaserelation.Entity.Guardian;

public class GuardianDto{
    private String guardianName;
    private String guardianNumber;
    private String guardianEmail;

    public GuardianDto() {
    }

    public GuardianDto(String guardianName, String guardianNumber, String guardianEmail) {
        this.guardianName = guardianName;
        this.guardianNumber = guardianNumber;
        this.guardianEmail = guardianEmail;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianNumber() {
        return guardianNumber;
    }

    public void setGuardianNumber(String guardianNumber) {
        this.guardianNumber = guardianNumber;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }
}
