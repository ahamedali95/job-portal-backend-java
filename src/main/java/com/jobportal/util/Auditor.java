package com.jobportal.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class Auditor {

  @Column(name = "created_date", updatable = false)
  @CreatedDate
  private LocalDateTime createdDate;

  @Column(name = "modified_date")
  @LastModifiedDate
  private LocalDateTime modifiedDate;

  @Column(name = "created_by", updatable = false)
  @CreatedBy
  private String createdBy;

  @Column(name = "modified_by")
  @LastModifiedBy

  private String modifiedBy;

  @PrePersist
  private void setCreatedDate() {
    setCreatedDate(LocalDateTime.now());
  }

  @PreUpdate
  private void setModifiedDate() {
    setModifiedDate(LocalDateTime.now());
  }
}
