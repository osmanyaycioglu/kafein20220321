package com.training.spring.person.rest.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.training.spring.models.Person;
import com.training.spring.models.PersonCredential;
import com.training.spring.models.Storage;
import com.training.spring.person.rest.models.PersonRest;
import com.training.spring.person.rest.models.StorageRest;

@Mapper
public interface IPersonMapper {

    IPersonMapper personMapper = Mappers.getMapper(IPersonMapper.class);

    @Mapping(source = "credential", target = "personCredential")
    Person toPerson(PersonRest personRestParam,
                    PersonCredential credential);

    PersonRest fromPerson(Person personParam);

    List<Person> toPersons(List<PersonRest> personRestParam);

    List<PersonRest> fromPersons(List<Person> personParam);

    Storage toStorage(StorageRest storageRestParam);

    StorageRest fromStorage(Storage storageParam);

    PersonCredential toPersonCredential(PersonRest person);

}
