package com.jobportal.resource;

import com.jobportal.Entity.Person;
import com.jobportal.service.PersonService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
  @Autowired
  private PersonService personService;

  public List<Person> getPeople() {
    return personService.getAllPeople();
  }

  public Person getPerson(long id) {
    return personService.getPersonById(id);
  }
}
