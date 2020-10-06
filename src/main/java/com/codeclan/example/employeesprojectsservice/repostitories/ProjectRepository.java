package com.codeclan.example.employeesprojectsservice.repostitories;

import com.codeclan.example.employeesprojectsservice.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
