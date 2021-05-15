package com.jobportal.Entity;

import com.jobportal.util.Auditor;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "WORK_HISTORY")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class WorkHistory extends Auditor {
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
  private Person person;
}
