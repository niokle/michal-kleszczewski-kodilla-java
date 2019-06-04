package com.kodilla.hibernate.manytomany.facade.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@NamedQuery(name="Company.findByName", query="SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE '%' + :ARG + '%'")
public interface CompanyDaoFacade extends CrudRepository<Company, Integer> {
    @Query
    List<Company> findCompanyByNameContains(@Param("ARG") String containsChars);
}
