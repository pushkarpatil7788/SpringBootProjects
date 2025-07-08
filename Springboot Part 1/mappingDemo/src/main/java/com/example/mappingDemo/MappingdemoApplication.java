package com.example.mappingDemo;

import com.example.mappingDemo.beans.Courses;
import com.example.mappingDemo.beans.Departments;
import com.example.mappingDemo.beans.Students;
import com.example.mappingDemo.services.CourseServicesInterface;
import com.example.mappingDemo.services.DepartmentServicesInterface;
import com.example.mappingDemo.services.StudentInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MappingdemoApplication implements CommandLineRunner {

	@Autowired
	private DepartmentServicesInterface departmentService;
	@Autowired
	private CourseServicesInterface courseServices;
	@Autowired
	private StudentInterface studentService;

	public static void main(String[] args) {
		SpringApplication.run(MappingdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 1 to add new department");
		System.out.println("Enter 2 to get all departments");
		System.out.println("Enter 3 to add student with courses");
		int option = scanner.nextInt();
		scanner.nextLine(); // clear buffer

		switch (option) {
			case 1:
				List<Students> sList = new ArrayList<>();
				System.out.println("Enter number of students to add:");
				int n = scanner.nextInt();
				scanner.nextLine();

				for (int i = 0; i < n; i++) {
					System.out.println("Enter student name:");
					String sname = scanner.nextLine();
					System.out.println("Enter student email:");
					String smail = scanner.nextLine();

					Students s = new Students(sname, smail);
					sList.add(s);
				}

				System.out.println("Enter department name:");
				String dname = scanner.nextLine();

				Departments department = new Departments(dname);
				department.setStudentList(sList);
				for (Students s : sList) {
					s.setDepartment(department);
				}

				departmentService.saveDepartment(department);
				System.out.println("Department and students saved!");
				break;

			case 2:
				List<Departments> depts = departmentService.getAllDepartments();
				for (Departments dept : depts) {
					System.out.println("Department: " + dept.getDeptName());
					for (Students s : dept.getStudentList()) {
						System.out.println(" -> Student: " + s.getStudentName() + " | Email: " + s.getStudentEmail());
					}
				}
				break;

			case 3:
				System.out.println("Enter student name:");
				String sname = scanner.nextLine();
				System.out.println("Enter student email:");
				String smail = scanner.nextLine();
				System.out.println("Enter department ID:");
				int deptId = scanner.nextInt();
				scanner.nextLine();
				Departments department1 = departmentService.findDepartment(deptId);
				List<Courses> coursesList = new ArrayList<>();
				System.out.println("Enter number of courses to add:");
				int ncourses = scanner.nextInt();
				scanner.nextLine();

				for (int i = 0; i < ncourses; i++) {
					System.out.println("Enter course name:");
					String courseName = scanner.nextLine();
					Courses course = new Courses();
					course.setCourseName(courseName);
					coursesList.add(course);
				}

				Students student = new Students(sname, smail);
				student.setDepartment(department1);
				student.setCoursesList(coursesList);

				for (Courses course : coursesList) {
					course.setStudent(student);
				}

				studentService.saveStudent(student);
				System.out.println("Student and courses saved!");
				break;

			default:
				System.out.println("Select valid option");
		}
	}
}
