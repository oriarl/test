package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
