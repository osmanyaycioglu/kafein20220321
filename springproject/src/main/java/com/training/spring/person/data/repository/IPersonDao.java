package com.training.spring.person.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.spring.models.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {

}
