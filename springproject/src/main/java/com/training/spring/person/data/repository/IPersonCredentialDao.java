package com.training.spring.person.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.spring.models.PersonCredential;

public interface IPersonCredentialDao extends CrudRepository<PersonCredential, Long> {

}
