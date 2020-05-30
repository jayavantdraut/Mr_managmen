package com.bostonbyte.mr_management.representative.resource.request;

import javax.validation.constraints.NotEmpty;

public class DrugRequest {
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Company is required")
    private String company;
    @NotEmpty(message = "Code is required")
    private String code;
    private String description;

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
