package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entities.Company;

import java.lang.String;
import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

	List<Company> findByEmail(String email);
	
	
}
