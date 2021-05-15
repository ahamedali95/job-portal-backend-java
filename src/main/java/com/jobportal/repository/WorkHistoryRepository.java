package com.jobportal.repository;

import com.jobportal.Entity.WorkHistory;
import org.hibernate.jdbc.Work;
import org.springframework.data.repository.CrudRepository;

public interface WorkHistoryRepository extends CrudRepository<WorkHistory, Long> {
}
