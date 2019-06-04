package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.facade.dao.CompanyDaoFacade;
import com.kodilla.hibernate.manytomany.facade.dao.EmployeeDaoFacade;
import com.kodilla.hibernate.manytomany.facade.dto.CompanyDto;
import com.kodilla.hibernate.manytomany.facade.dto.EmployeeDto;
import com.kodilla.hibernate.manytomany.facade.exception.FindCompanyException;
import com.kodilla.hibernate.manytomany.facade.exception.FindEmployeeException;
import com.kodilla.hibernate.manytomany.facade.mapper.FacadeMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindFacade {

    EmployeeDaoFacade employeeDaoFacade;

    CompanyDaoFacade companyDaoFacade;

    FacadeMapper facadeMapper;

    public List<EmployeeDto> findEmployeeByName(String name) throws FindEmployeeException {
        return employeeDaoFacade.findEmployeeByLastnameContainsOrFirstnameContains(name).stream()
                .map(employee -> facadeMapper.EmployeeToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    public List<CompanyDto> findCompanyByName(String name) throws FindCompanyException {
        return companyDaoFacade.findCompanyByNameContains(name).stream()
                .map(company -> facadeMapper.CompanyToCompanyDto(company))
                .collect(Collectors.toList());
    }
}
