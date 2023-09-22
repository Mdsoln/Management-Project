package com.muddy.databaserelation.Entity;

import jakarta.persistence.Embeddable;

import javax.validation.constraints.NotEmpty;
@Embeddable
public class Guardian {
    @NotEmpty(message = "Guardian name is required")
    private String guardianName;
    @NotEmpty(message = "Guardian number is required")
    private String guardianNumber;
    @NotEmpty(message = "Guardian email is required")
    private String guardianEmail;

    public Guardian() {
    }

    public Guardian(String guardianName, String guardianNumber, String guardianEmail) {
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
