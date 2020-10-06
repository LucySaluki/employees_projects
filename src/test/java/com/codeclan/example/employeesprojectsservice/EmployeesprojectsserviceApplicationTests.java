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

		Project project= new Project("Java App",10);
		projectRepository.save(project);

		Employee employee = new Employee("Joe", "Bloggs", 40,department);
		Employee employee1 = new Employee("Fred", "Smith",29,department);
		Employee employee2 = new Employee("Jane","Doe",13,department);

//		project.addEmployeeToProject(employee);
//		project.addEmployeeToProject(employee1);
//		project.addEmployeeToProject(employee2);

		employee.addProjectToEmployee(project);
		employee1.addProjectToEmployee(project);
		employee2.addProjectToEmployee(project);

		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
	}
}
