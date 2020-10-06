package com.codeclan.example.employeesprojectsservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="number_of_days")
    private int numberOfDays;

    @JsonIgnoreProperties({"projects"})
    @ManyToMany
    @JoinTable(
            name="employees_projects",
            joinColumns = {@JoinColumn(
                    name = "project_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = {@JoinColumn(
                    name="employee_id",
                    nullable = false,
                    updatable = false
            )}
    )
    private List<Employee> employees;

    public Project(String name, int numberOfDays) {
        this.name = name;
        this.numberOfDays = numberOfDays;
        this.employees = new ArrayList<Employee>();
    }
    public Project(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployeeToProject(Employee employee){
        this.employees.add(employee);
    }
}
