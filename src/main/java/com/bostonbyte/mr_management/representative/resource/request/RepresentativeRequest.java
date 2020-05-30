package com.bostonbyte.mr_management.representative.resource.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class RepresentativeRequest {
    @NotNull(message = "first name required ")
    @Length(max = 30)
    private String firstName;
    private String lastName;
    private String address;
    private String qualification;
    private Set<Integer> drugIds;
    @NotNull(message = "mobile number required ")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "valid mobile number required ")
    private String mobile;
    @NotNull(message = " valid email required")
    @Email(message = " valid email required")
    private String email;

    public Set<Integer> getDrugIds() {
        return drugIds;
    }

    public void setDrugIds(Set<Integer> drugIds) {
        this.drugIds = drugIds;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
