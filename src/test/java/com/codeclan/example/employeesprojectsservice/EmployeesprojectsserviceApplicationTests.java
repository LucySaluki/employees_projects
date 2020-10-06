package com.codeclan.example.employeesprojectsservice;

import com.codeclan.example.employeesprojectsservice.models.Department;
import com.codeclan.example.employeesprojectsservice.models.Employee;
import com.codeclan.example.employeesprojectsservice.models.Project;
import com.codeclan.example.employeesprojectsservice.repostitories.DepartmentRepository;
import com.codeclan.example.employeesprojectsservice.repostitories.EmployeeRepository;
import com.codeclan.example.employeesprojectsservice.repostitories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeesprojectsserviceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void populateTables(){
		Department department = new Department("IT Dept");
		departmentRepository.save(department);
		Project project= new Project("Java App",100);
		Employee employee = new Employee("Ben", "Davidson", 32,department);
		Employee employee1 = new Employee("Tim", "Sanders",58,department);
		Employee employee2 = new Employee("Lucy","Arnold",30,department);
		project.addEmployeeToProject(employee);
		project.addEmployeeToProject(employee1);
		project.addEmployeeToProject(employee2);
		employee.addProjectToEmployee(project);
		employee1.addProjectToEmployee(project);
		employee2.addProjectToEmployee(project);
		projectRepository.save(project);
		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
	}
}
