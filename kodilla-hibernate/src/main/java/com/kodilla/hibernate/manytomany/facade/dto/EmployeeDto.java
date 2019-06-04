package com.kodilla.hibernate.manytomany.facade.dto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {
    private int id;
    private String firstname;
    private String lastname;
    private List<CompanyDto> companyDtos = new ArrayList<>();

    public EmployeeDto(int id, String firstname, String lastname, List<CompanyDto> companyDtos) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.companyDtos = companyDtos;
    }
}
