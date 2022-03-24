package com.training.spring.person.rest.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.training.spring.core.confprop.Person;
import com.training.spring.person.rest.models.PersonRest;

@Mapper
public interface IPersonMapper {

    IPersonMapper personMapper = Mappers.getMapper(IPersonMapper.class);

    Person toPerson(PersonRest personRestParam);

    PersonRest fromPerson(Person personParam);


    List<Person> toPersons(List<PersonRest> personRestParam);

    List<PersonRest> fromPersons(List<Person> personParam);


}
