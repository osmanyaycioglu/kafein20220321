package com.training.spring.person.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.spring.models.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameAndSurname(String name,
                                      String surname);

    List<Person> findByNameAndSurnameOrderByPersonId(String name,
                                                     String surname);

    List<Person> findByNameInOrderByName(List<String> name);

    List<Person> findByNameLike(String likeName);

    @Query("select p from Person p where p.name = ?1")
    List<Person> searchName(String name);

    @Query("select p from Person p where p.name = :isim")
    List<Person> searchName2(@Param("isim") String name);

    @Query("select p.name,p.surname,p.storage.name from Person p where p.name = :isim")
    List<Object[]> searchName3(@Param("isim") String name);

    @Query(value = "select * from person p where p.name = ?1", nativeQuery = true)
    List<Person> searchNameNative(String name);

}
