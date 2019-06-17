package com.kodilla.hibernate.manytomany.facade.mapper;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.dto.CompanyDto;
import com.kodilla.hibernate.manytomany.facade.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacadeMapper {

    public CompanyDto CompanyToCompanyDto(Company company) {
        return new CompanyDto(company.getId(), company.getName(), ListEmployeeToListEmployeeDto(company.getEmployees()));
    }

    public List<CompanyDto> ListCompanyToListCompanyDto(List<Company> companies) {
        return companies.stream()
                .map(company -> new CompanyDto(company.getId(), company.getName(),
                        ListEmployeeToListEmployeeDto(company.getEmployees())))
                .collect(Collectors.toList());
    }

    public EmployeeDto EmployeeToEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getFirstname(), employee.getLastname(), ListCompanyToListCompanyDto(employee.getCompanies()));
    }

    public List<EmployeeDto> ListEmployeeToListEmployeeDto(List<Employee> employees) {
        return employees.stream()
                .map(employee -> new EmployeeDto(employee.getId(), employee.getFirstname(), employee.getLastname(),
                        ListCompanyToListCompanyDto(employee.getCompanies())))
                .collect(Collectors.toList());
    }

}
