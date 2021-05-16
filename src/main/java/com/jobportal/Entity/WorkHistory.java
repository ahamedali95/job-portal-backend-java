package com.jobportal.Entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "WORK_HISTORY")
@Builder
public class WorkHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String fromDate;
  private String endDate;
  private String companyName;
  private String businessType;
  private String businessTitle;
  @Type(type="yes_no")
  private Boolean isCurrentEmployer;
  private Integer displayOrder;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="person_id")
  private Person person;
}
