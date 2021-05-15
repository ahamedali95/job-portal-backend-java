package com.jobportal.Entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PERSON")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String email;
  private String primaryPhone;
  private String nickname;
  private String suffix;
  private String alternatePhoneNumber;
  private String streetAddress;
  private String extendedAddress1;
  private String extendedAddress2;
  private String city;
  private String state;
  private Integer zipCode;
  private String country;
}