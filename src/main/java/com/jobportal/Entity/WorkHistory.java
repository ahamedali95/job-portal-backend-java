package com.jobportal.Entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "WORK_HISTORY")
public class WorkHistory {
  private String fromDate;
  private String endDate;
  private String companyName;
  private String businessType;
  private String businessTitle;
  @Type(type="yes_no")
  private String isCurrentEmployer;
}
