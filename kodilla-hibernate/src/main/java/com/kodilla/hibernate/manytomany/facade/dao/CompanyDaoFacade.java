package com.kodilla.hibernate.manytomany.facade.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@NamedQuery(name="Company.findByName", query="SELECT * FROM companies WHERE company_name LIKE '%' + :ARG + '%'")
public interface CompanyDaoFacade extends CrudRepository<Company, Integer> {
    List<Company> findCompanyByNameContains(@Param("ARG") String containsChars);
}
