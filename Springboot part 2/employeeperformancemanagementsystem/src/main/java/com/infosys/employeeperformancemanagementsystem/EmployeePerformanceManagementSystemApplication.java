package com.infosys.employeeperformancemanagementsystem;

import com.infosys.employeeperformancemanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EmployeePerformanceManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private DepartmentServiceInterface departmentService;

	@Autowired
	private EmployeeServiceInterface employeeService;

	@Autowired
	private ProjectServiceInterface projectService;

	@Autowired
	private PerformanceReviewServiceInterface reviewService;

	@Autowired
	@Qualifier("standardBonusService")
	private BonusServiceInterface standardBonusService;

	@Autowired
	@Qualifier("executiveBonusService")
	private BonusServiceInterface executiveBonusService;


	public static void main(String[] args) {
		SpringApplication.run(EmployeePerformanceManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("Enter 1 to Add Department");
			System.out.println("Enter 2 to Add Employee");
			System.out.println("Enter 3 to Assign Projects");
			System.out.println("Enter 4 to Add Performance Review");
			System.out.println("Enter 5 to Calculate Bonus");
			System.out.println("Enter 6 to Add Project");
			System.out.println("Enter 7 to Exit");

			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					System.out.print("Enter department name: ");
					String dname = sc.nextLine();
					departmentService.addDepartment(dname);
					break;
				case 2:
					System.out.print("Enter employee name: ");
					String ename = sc.nextLine();
					System.out.print("Enter salary: ");
					double salary = Double.parseDouble(sc.nextLine());
					System.out.print("Enter rating: ");
					int rating = Integer.parseInt(sc.nextLine());
					System.out.print("Enter department ID: ");
					int deptId = Integer.parseInt(sc.nextLine());
					employeeService.addEmployee(ename, salary, rating, deptId);
					break;
				case 3:
					System.out.print("Enter Employee ID: ");
					int empId = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Project IDs to assign : ");
					String[] ids = sc.nextLine().split(",");
					List<Integer> projectIds = Arrays.stream(ids).map(Integer::parseInt).toList();
					employeeService.assignProjects(empId, projectIds);
					break;
				case 4:
					System.out.print("Enter Employee ID: ");
					int empIdReview = Integer.parseInt(sc.nextLine());
					System.out.print("Enter rating: ");
					int reviewRating = Integer.parseInt(sc.nextLine());
					System.out.print("Enter remarks: ");
					String remarks = sc.nextLine();
					reviewService.addReview(empIdReview, reviewRating, remarks);
					reviewService.listReviewsByEmployee(empIdReview);
					break;
				case 5:
					System.out.print("Enter employee type [standard/executive]: ");
					String type = sc.nextLine().toLowerCase();
					System.out.print("Enter employee rating: ");
					int r = Integer.parseInt(sc.nextLine());
					System.out.print("Enter employee salary: ");
					double s = Double.parseDouble(sc.nextLine());

					double bonus = type.equals("executive")
							? executiveBonusService.calculateBonus(r, s)
							: standardBonusService.calculateBonus(r, s);
					System.out.println(" Calculated bonus = " + bonus);
					break;

				case 6:
					System.out.print("Enter project title: ");
					String title = sc.nextLine();

					System.out.print("Enter project duration (in months): ");
					int duration = Integer.parseInt(sc.nextLine());

					projectService.addProject(title, duration);
					break;

				case 7:
					System.out.println("Exit");
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}
}
