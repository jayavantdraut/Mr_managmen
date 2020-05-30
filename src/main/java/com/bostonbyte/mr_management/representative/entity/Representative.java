package com.bostonbyte.mr_management.representative.entity;

import com.bostonbyte.mr_management.core.entity.JpaEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "representative")
public class Representative extends JpaEntity {
    private String firstName;
    private String lastName;
    private String qualification;
    private String mobile;
    private String email;
    private  String address;
    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
            @JoinTable(name = "representative_drug",
            joinColumns = {@JoinColumn(name="representative_id")},
            inverseJoinColumns = {@JoinColumn(name = "drug_id")})
    List<Drug> drugs = Collections.emptyList();
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

    public List<Drug> getDrugs() {
        return drugs;
    }


    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
