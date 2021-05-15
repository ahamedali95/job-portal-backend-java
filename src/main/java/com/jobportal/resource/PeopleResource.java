package com.jobportal.resource;

import com.jobportal.Entity.Person;
import com.jobportal.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/")
public class PeopleResource {
  @Autowired
  private PersonService personService;

  @GetMapping(path = "people")
  private List<Person> getAllPeople() {
    return personService.getAllPeople();
  }
}
