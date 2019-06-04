package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            employeeDao.delete(johnSmith);
            employeeDao.delete(stephanieClarckson);
            employeeDao.delete(lindaKovalsky);
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testNamedQueries() {
        //given
        Employee janKowalski = new Employee("Jan", "Kowalski");
        Employee piotrKowalski = new Employee("Piotr", "Kowalski");
        Employee emiliaKowalska = new Employee("Emilia", "Kowalska");
        Employee ewaZewa = new Employee("Ewa", "Zewa");
        Employee kasiaZewa = new Employee("Kasia", "Zewa");
        Employee michalZewa = new Employee("Michal", "Zewa");

        Company ibm = new Company("IBM");
        Company microsoft = new Company("Microsoft");

        ibm.getEmployees().add(janKowalski);
        ibm.getEmployees().add(emiliaKowalska);
        ibm.getEmployees().add(kasiaZewa);
        microsoft.getEmployees().add(piotrKowalski);
        microsoft.getEmployees().add(ewaZewa);
        microsoft.getEmployees().add(michalZewa);

        //when
        companyDao.save(ibm);
        int ibmId = ibm.getId();
        companyDao.save(microsoft);
        int microsoftId = microsoft.getId();
        List<Employee> lastNameKowalski = employeeDao.findEmployeesByLastname("Kowalski");
        List<Employee> lastNameZewa = employeeDao.findEmployeesByLastname("Zewa");

        //then
        Assert.assertEquals(2, lastNameKowalski.size());
        Assert.assertEquals(3, lastNameZewa.size());

        //cleanUp
        try {
            employeeDao.delete(janKowalski);
            employeeDao.delete(piotrKowalski);
            employeeDao.delete(emiliaKowalska);
            employeeDao.delete(ewaZewa);
            employeeDao.delete(kasiaZewa);
            employeeDao.delete(michalZewa);
            companyDao.delete(ibmId);
            companyDao.delete(microsoftId);
        } catch (Exception e) {

        }
    }

    @Test
    public void testNamedNativeQueries() {
        //given
        Employee janKowalski = new Employee("Jan", "Kowalski");
        Employee piotrKowalski = new Employee("Piotr", "Kowalski");
        Employee emiliaKowalska = new Employee("Emilia", "Kowalska");
        Employee ewaZewa = new Employee("Ewa", "Zewa");
        Employee kasiaZewa = new Employee("Kasia", "Zewa");
        Employee michalZewa = new Employee("Michal", "Zewa");

        Company microtrend = new Company("Microtrend");
        Company microsoft = new Company("Microsoft");
        Company michalinski = new Company("Michalinski");
        Company milos = new Company("Milos");

        microtrend.getEmployees().add(janKowalski);
        microtrend.getEmployees().add(piotrKowalski);
        microsoft.getEmployees().add(emiliaKowalska);
        microsoft.getEmployees().add(ewaZewa);
        michalinski.getEmployees().add(kasiaZewa);
        milos.getEmployees().add(michalZewa);

        //when
        companyDao.save(microtrend);
        int microtrendId = microtrend.getId();
        companyDao.save(microsoft);
        int microsoftId = microsoft.getId();
        companyDao.save(michalinski);
        int michalinskiId = michalinski.getId();
        companyDao.save(milos);
        int milosId = milos.getId();

        List<Company> firstCharMic = companyDao.findCompanyByFristThreeChars("Mic");
        List<Company> firstCharMil = companyDao.findCompanyByFristThreeChars("Mil");

        //then
        Assert.assertEquals(3, firstCharMic.size());
        Assert.assertEquals(1, firstCharMil.size());

        //cleanUp
        try {
            employeeDao.delete(janKowalski);
            employeeDao.delete(piotrKowalski);
            employeeDao.delete(emiliaKowalska);
            employeeDao.delete(ewaZewa);
            employeeDao.delete(kasiaZewa);
            employeeDao.delete(michalZewa);
            companyDao.delete(microtrendId);
            companyDao.delete(microsoftId);
            companyDao.delete(michalinskiId);
            companyDao.delete(milosId);
        } catch (Exception e) {

        }
    }


}