package com.kodilla.hibernate.manytomany.facade.dto;

import java.util.ArrayList;
import java.util.List;

public class CompanyDto {
    private int id;
    private String name;
    private List<EmployeeDto> employeeDtos = new ArrayList<>();

    public CompanyDto(int id, String name, List<EmployeeDto> employeeDtos) {
        this.id = id;
        this.name = name;
        this.employeeDtos = employeeDtos;
    }
}

