package com.jobportal.service;

import com.jobportal.Entity.Person;
import com.jobportal.Entity.WorkHistory;
import com.jobportal.repository.PersonRepository;
import com.jobportal.repository.WorkHistoryRepository;
import com.jobportal.util.IdentifierNotFoundException;
import com.jobportal.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private WorkHistoryRepository workHistoryRepository;

  @Transactional
  public List<Person> getAllPeople() {
    List<Person> people = new ArrayList<>();

    personRepository.findAll().forEach(people::add);

    return people;
  }

  @Transactional
  public Person getPersonById(long id) throws ResourceNotFoundException {
    Optional<Person> person = personRepository.findById(id);

    if (person.isPresent()) {
      return person.get();
    } else {
      throw new ResourceNotFoundException();
    }
  }

  @Transactional
  public Person createPerson(Person person) {
    Person newPerson = Person.builder()
            .id(person.getId())
            .firstName(person.getFirstName())
            .middleName(person.getMiddleName())
            .lastName(person.getLastName())
            .email(person.getEmail())
            .primaryPhone(person.getPrimaryPhone())
            .nickname(person.getNickname())
            .suffix(person.getSuffix())
            .alternatePhoneNumber(person.getAlternatePhoneNumber())
            .streetAddress(person.getStreetAddress())
            .extendedAddress1(person.getExtendedAddress1())
            .extendedAddress2(person.getExtendedAddress2())
            .city(person.getCity())
            .state(person.getState())
            .zipCode(person.getZipCode())
            .country(person.getCountry())
            .workHistoryList(person.getWorkHistoryList())
            .build();

    for (WorkHistory workHistory: person.getWorkHistoryList()) {
      WorkHistory $workHistory = WorkHistory.builder()
              .id(workHistory.getId())
              .companyName(workHistory.getCompanyName())
              .businessType(workHistory.getBusinessType())
              .fromDate(workHistory.getFromDate())
              .endDate(workHistory.getEndDate())
              .businessType(workHistory.getBusinessType())
              .isCurrentEmployer(workHistory.getIsCurrentEmployer())
              .displayOrder(workHistory.getDisplayOrder())
              .person(newPerson)
              .build();
      workHistoryRepository.save($workHistory);
    }

    return personRepository.save(newPerson);
  }

  @Transactional
  public Person updatePerson(Person person) throws IdentifierNotFoundException, ResourceNotFoundException {
    if (person.getId() != null) {
      if (getPersonById(person.getId()) != null) {
        Person newPerson = Person.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .middleName(person.getMiddleName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .primaryPhone(person.getPrimaryPhone())
                .nickname(person.getNickname())
                .suffix(person.getSuffix())
                .alternatePhoneNumber(person.getAlternatePhoneNumber())
                .streetAddress(person.getStreetAddress())
                .extendedAddress1(person.getExtendedAddress1())
                .extendedAddress2(person.getExtendedAddress2())
                .city(person.getCity())
                .state(person.getState())
                .zipCode(person.getZipCode())
                .country(person.getCountry())
                .workHistoryList(person.getWorkHistoryList())
                .build();

        for (WorkHistory workHistory: person.getWorkHistoryList()) {
          WorkHistory $workHistory = WorkHistory.builder()
                  .id(workHistory.getId())
                  .companyName(workHistory.getCompanyName())
                  .businessType(workHistory.getBusinessType())
                  .fromDate(workHistory.getFromDate())
                  .endDate(workHistory.getEndDate())
                  .businessType(workHistory.getBusinessType())
                  .isCurrentEmployer(workHistory.getIsCurrentEmployer())
                  .displayOrder(workHistory.getDisplayOrder())
                  .person(newPerson)
                  .build();
          workHistoryRepository.save($workHistory);
        }

        return personRepository.save(newPerson);
      } else {
        throw new ResourceNotFoundException();
      }
    } else {
      throw new IdentifierNotFoundException();
    }
  }
}
