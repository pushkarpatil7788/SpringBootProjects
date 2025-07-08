package com.infosys.jpaentitydemo;

import com.infosys.jpaentitydemo.beans.Employees;
import com.infosys.jpaentitydemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JpaentitydemoApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(JpaentitydemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add employee");
		System.out.println("Enter 2 to find employee");
		System.out.println("Enter 3 to update employee");
		System.out.println("Enter 4 to remove employee");
		System.out.println("Enter 5 to display all employees");
		System.out.println("Enter 6 to employee email to search:");
		System.out.println("Enter 7 to Employee ID to validate: ");
		System.out.println("Enter your choice:");
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				System.out.println("Enter Employee name:");
				String empName = scanner.next();
				System.out.println("Enter Employee email:");
				String empEmail = scanner.next();
				Employees emp = new Employees();
				emp.setEmployeeName(empName);
				emp.setEmployeeEmail(empEmail);
				Employees savedEmp = employeeService.addEmployee(emp);
				System.out.println("Saved: " + savedEmp);
				break;

			case 2:
				employeeService.findEmployee();
				break;

			case 3:
				System.out.println("Enter Employee ID to update:");
				int updateId = scanner.nextInt();
				System.out.println("Enter new name:");
				String newName = scanner.next();
				System.out.println("Enter new email:");
				String newEmail = scanner.next();
				Employees updatedEmp = employeeService.updateEmployee(updateId, newName, newEmail);
				if (updatedEmp != null) {
					System.out.println("Updated successfully: " + updatedEmp);
				} else {
					System.out.println("Employee not found with ID: " + updateId);
				}
				break;

			case 4:
				System.out.print("Enter Employee ID to remove: ");
				int removeId = scanner.nextInt();
				employeeService.removeEmployee(removeId);
				break;

			case 5:
				List<Employees> allEmployees = employeeService.findAllEmployees();
				for (Employees e : allEmployees) {
					System.out.println(e);
				}
				break;

			case 6:
				System.out.print("Enter employee email to search: ");
				String mailId = scanner.next();
				employeeService.findByEmail(mailId);
				break;

			case 7:
				System.out.print("Enter Employee ID to validate: ");
				int empId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Employee Email to validate: ");
				String empMail = scanner.nextLine();

				employeeService.validateEmployee(empId, empMail);
				break;

			default:
				System.out.println("Invalid choice.");
		}
	}
}
