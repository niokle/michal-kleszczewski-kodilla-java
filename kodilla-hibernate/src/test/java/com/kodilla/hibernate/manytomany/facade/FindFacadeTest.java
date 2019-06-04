package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.dto.CompanyDto;
import com.kodilla.hibernate.manytomany.facade.dto.EmployeeDto;
import com.kodilla.hibernate.manytomany.facade.exception.FindCompanyException;
import com.kodilla.hibernate.manytomany.facade.exception.FindEmployeeException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindFacadeTest {

    @Autowired
    FindFacade findFacade;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void findEmployeeByName() throws FindEmployeeException {
        //given
        Employee employee1 = new Employee("Michal", "Kleszczewski");
        Employee employee2 = new Employee("Maciej", "Pleszczewski");
        Employee employee3 = new Employee("Marcin", "Wleszczewski");
        Employee employee4 = new Employee("Zenon", "Dreszczewski");
        Employee employee5 = new Employee("Zbyszek", "Zleszczewski");
        Employee employee6 = new Employee("Zigi", "Sleszczewski");
        Employee employee7 = new Employee("Bartek", "Bleszczewski");
        Employee employee8 = new Employee("Bogdan", "Gleszczewski");
        Employee employee9 = new Employee("Piotr", "Mleszczewski");

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        employeeDao.save(employee4);
        employeeDao.save(employee5);
        employeeDao.save(employee6);
        employeeDao.save(employee7);
        employeeDao.save(employee8);
        employeeDao.save(employee9);

        //when
        List<EmployeeDto> employees1 = findFacade.findEmployeeByName("szczew");
        List<EmployeeDto> employees2 = findFacade.findEmployeeByName("Ma");
        List<EmployeeDto> employees3 = findFacade.findEmployeeByName("en");

        //then
        Assert.assertEquals(9, employees1.size());
        Assert.assertEquals(2, employees2.size());
        Assert.assertEquals(1, employees3.size());

        //cleanup
        employeeDao.delete(employee1);
        employeeDao.delete(employee2);
        employeeDao.delete(employee3);
        employeeDao.delete(employee4);
        employeeDao.delete(employee5);
        employeeDao.delete(employee6);
        employeeDao.delete(employee7);
        employeeDao.delete(employee8);
        employeeDao.delete(employee9);
    }

    @Test
    public void findCompanyByName() throws FindCompanyException {
        //given
        Company company1 = new Company("Microsoft");
        Company company2 = new Company("Google");
        Company company3 = new Company("Micros");
        Company company4 = new Company("Doodle");
        Company company5 = new Company("Microservice");
        Company company6 = new Company("Zoogle");
        Company company7 = new Company("Apple");
        Company company8 = new Company("IBM");
        Company company9 = new Company("Plede");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);
        companyDao.save(company5);
        companyDao.save(company6);
        companyDao.save(company7);
        companyDao.save(company8);
        companyDao.save(company9);

        //when
        List<CompanyDto> companies1 = findFacade.findCompanyByName("Micro");
        List<CompanyDto> companies2 = findFacade.findCompanyByName("ogle");
        List<CompanyDto> companies3 = findFacade.findCompanyByName("le");

        //then
        Assert.assertEquals(3, companies1.size());
        Assert.assertEquals(3, companies1.size());
        Assert.assertEquals(4, companies1.size());

        //cleanup
        companyDao.delete(company1);
        companyDao.delete(company2);
        companyDao.delete(company3);
        companyDao.delete(company4);
        companyDao.delete(company5);
        companyDao.delete(company6);
        companyDao.delete(company7);
        companyDao.delete(company8);
        companyDao.delete(company9);
    }
}