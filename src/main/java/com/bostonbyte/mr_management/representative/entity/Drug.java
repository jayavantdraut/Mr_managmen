package com.bostonbyte.mr_management.representative.entity;

import com.bostonbyte.mr_management.core.entity.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;

@Entity
@Table( name = "drugs")
public class Drug extends JpaEntity {
    @NotEmpty
    private String name;
    @NotEmpty
    private String company;
    @NotEmpty
    private String code;
    private String description;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "drugs")
    private List<Representative> representatives = Collections.emptyList();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
