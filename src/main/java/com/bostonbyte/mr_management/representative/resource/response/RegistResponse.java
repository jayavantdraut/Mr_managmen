package com.bostonbyte.mr_management.representative.resource.response;

import java.util.Collections;
import java.util.List;

public class RegistResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String qualification;
    private String mobile;
    private String email;
    private  String address;
    private List<DrugResponse> drugs = Collections.emptyList();
    public List<DrugResponse> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<DrugResponse> drugs) {
        this.drugs = drugs;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
