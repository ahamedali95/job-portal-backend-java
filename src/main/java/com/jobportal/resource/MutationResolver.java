package com.jobportal.resource;

import com.jobportal.Entity.Person;
import com.jobportal.service.PersonService;
import com.jobportal.util.ResourceNotFoundException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {
  @Autowired
  private PersonService personService;

  public Person updatePerson(Person person) throws ResourceNotFoundException {
    return personService.updatePerson(person);
  }

  public Person createPerson(Person person) {
    return personService.createPerson(person);
  }
}
