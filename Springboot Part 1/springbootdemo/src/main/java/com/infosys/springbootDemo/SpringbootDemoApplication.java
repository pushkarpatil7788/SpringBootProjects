package com.infosys.springbootDemo;

import com.infosys.springbootDemo.beans.Batches;
import com.infosys.springbootDemo.beans.Laptops;
import com.infosys.springbootDemo.beans.Student;
import com.infosys.springbootDemo.services.BatchServices;
import com.infosys.springbootDemo.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SpringbootDemoApplication implements CommandLineRunner {

	@Autowired
	BatchServices batchServices;

	@Autowired
	StudentServices studentServices;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add new batch");
		System.out.println("Enter 2 to add multiple batches");
		System.out.println("Enter 3 to find the batch on basis of id");
		System.out.println("Enter 4 to update batch details");
		System.out.println("Enter 5 to remove batch");
		System.out.println("Enter 6 to view all batches");
		System.out.println("Enter 7 to view all batches from list using Query using JPQL :");
		System.out.println("Enter 8 to view all Batch Start Date based on  Query using JPQL : ");
		System.out.println("Enter 9 to saves update ");
		System.out.println("Enter your choise :-");


		int operation = scanner.nextInt();

		switch (operation) {
			case 1:
				System.out.println("Enter Batch Name");
				String batchName = scanner.next();
				System.out.println("Enter Batch Start Date");
				String startDate = scanner.next();
				System.out.println("Enter Batch End Date");
				String endDate = scanner.next();
				Batches batch1 = new Batches();
				batch1.setBatchName(batchName);
				batch1.setBatchStartDate(startDate);
				batch1.setBatchEndDate(endDate);
				batchServices.addBatch(batch1);
				break;

			case 2:
				System.out.println("How many batches do you want to add?");
				int noOfBatches = scanner.nextInt();
				List<Batches> batchesList = new ArrayList<>();
				for (int i = 0; i < noOfBatches; i++) {
					System.out.println("Enter Batch Name");
					String batchName1 = scanner.next();
					System.out.println("Enter Batch Start Date");
					String startDate1 = scanner.next();
					System.out.println("Enter Batch End Date");
					String endDate1 = scanner.next();
					Batches batch2 = new Batches();
					batch2.setBatchName(batchName1);
					batch2.setBatchStartDate(startDate1);
					batch2.setBatchEndDate(endDate1);
					batchesList.add(batch2);
				}
				batchServices.addMultipleBatches(batchesList);
				break;

			case 3:
				System.out.println("Enter batchId to see batch details");
				int batchId = scanner.nextInt();
				try {
					Optional<Batches> optional = batchServices.findBatchById(batchId);
					Batches batch = optional.get();
					System.out.println(batch.toString());
				} catch (Exception e) {
					System.err.println("Id not found");
				}
				break;

			case 4:
				System.out.println("Enter batchId to update:");
				int updateId = scanner.nextInt();
				Optional<Batches> optionalBatch = batchServices.findBatchById(updateId);
				if (optionalBatch.isPresent()) {
					Batches existingBatch = optionalBatch.get();
					System.out.println("Existing Details:");
					System.out.println("Name: " + existingBatch.getBatchName());
					System.out.println("Start Date: " + existingBatch.getBatchStartDate());
					System.out.println("End Date: " + existingBatch.getBatchEndDate());

					System.out.println("Enter new Batch Name:");
					String newName = scanner.next();

					System.out.println("Enter new Start Date:");
					String newStart = scanner.next();

					System.out.println("Enter new End Date:");
					String newEnd = scanner.next();

					existingBatch.setBatchName(newName);
					existingBatch.setBatchStartDate(newStart);
					existingBatch.setBatchEndDate(newEnd);

					batchServices.updateBatch(existingBatch);
					System.out.println("Batch updated successfully.");
				} else {
					System.out.println("Batch not found with ID: " + updateId);
				}
				break;

			case 5:
				System.out.println("Enter Batch ID to delete:");
				int deleteId = scanner.nextInt();
				try {
					batchServices.deleteBatch(deleteId);
					System.out.println("Batch deleted successfully.");
				} catch (Exception e) {
					System.out.println("Failed to delete. ID may not exist.");
				}
				break;

			case 6:
				List<Batches> allBatches = batchServices.getAllBatches();
				if (allBatches.isEmpty()) {
					System.out.println("No batches found.");
				} else {
					System.out.println("All Batches:");
					for (Batches b : allBatches) {
						System.out.println(b);
					}
				}
				break;
			case 7:
				List<Batches> batchesList4 = batchServices.findAllBatchesUsingQuery();
				batchesList4.forEach((Batches batch) -> System.out.println(batch));
				break;

			case 8:
				Scanner case8 = new Scanner(System.in);

				System.out.print("Enter Batch Start Date: ");
				String startDate1 = case8.nextLine();
				System.out.print("Enter Batch Name: ");
				String batchName1 = case8.nextLine();
				Batches batch = batchServices.showBatchOnBasisOfStartDateAndName(startDate1, batchName1);

				if (batch != null) {
					System.out.println(batch);
				} else {
					System.out.println("No batch found with given start date and name.");
				}
				break;

			case 9:
				Laptops laptops=new Laptops();
				//laptops.setLaptopId(12345678);
				laptops.setLaptopName("lenovo idealpadgaming");
				Student s=new Student("Pushkar","Pushkar@infosys.com");
				s.setLaptops(laptops);

				studentServices.addStudent(s);
				System.out.println("student saved");
				break;

			default:
				System.out.println("Please select valid operation. Thank you!");
		}
	}
}
