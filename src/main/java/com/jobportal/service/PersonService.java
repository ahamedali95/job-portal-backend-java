package com.jobportal.service;

import com.jobportal.Entity.Person;
import com.jobportal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class PersonService {
  @Autowired
  private PersonRepository personRepository;

  public List<Person> getAllPeople() {
    List<Person> people = new ArrayList<>();

    personRepository.findAll().forEach(people::add);

    return people;
  }

  public Person getPersonById(long id) {
    if (personRepository.findById(id).isPresent()) {
      return personRepository.findById(id).get();
    } else {
      throw new RuntimeException();
    }
  }
}
