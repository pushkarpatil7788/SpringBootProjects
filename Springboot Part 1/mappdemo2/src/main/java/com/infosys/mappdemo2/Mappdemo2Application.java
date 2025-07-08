package com.infosys.mappdemo2;

import com.infosys.mappdemo2.beans.Courses;
import com.infosys.mappdemo2.beans.Department;
import com.infosys.mappdemo2.beans.Student;
import com.infosys.mappdemo2.services.DepartmentServices;
import com.infosys.mappdemo2.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class Mappdemo2Application implements CommandLineRunner {

	@Autowired
	DepartmentServices departmentServices;

	@Autowired
	StudentServices studentServices;

	public static void main(String[] args) {
		SpringApplication.run(Mappdemo2Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter 1 to add new departmrnt");
		System.out.println("enter 2 to find or get all department");

		int operation = scanner.nextInt();

		switch (operation){
			case 1:
				System.out.println("enter department name");
				String dname=scanner.next();
				Department department=new Department(dname);
				List<Student> slist=new ArrayList<>();
				System.out.println("enter numer of student to save");
				int n=scanner.nextInt();
				for(int i=0;i<n;i++){
					System.out.println("enter student name");
					String sname=scanner.next();
					System.out.println("enter student email");
					String semil=scanner.next();
					Student s=new Student(sname,semil);
					s.setDepartment(department);
					slist.add(s);
				}

				department.setStudentList(slist);
				departmentServices.saveDepartment(department);
				System.out.println("object is saved");
				break;

			case 3:
				System.out.println("enter student name");
				String sname=scanner.next();
				System.out.println("enter student email");
				String semil=scanner.next();
				System.out.println("enter dept id");
				int deptId=scanner.nextInt();


				Department department1=departmentServices.findDepartment(deptId);
				List<Courses> coursesList=new ArrayList<>();
				System.out.println("enter no of cources to add");
				int ncourses=scanner.nextInt();
				for(int i=0;i<ncourses;i++){

				}
				break;

			default:
				System.out.println("Please select valid operation. Thank you!");

		}
	}
}
