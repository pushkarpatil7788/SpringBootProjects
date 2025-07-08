package com.infosys.Customerrelationshipmanagement;

import com.infosys.Customerrelationshipmanagement.beans.Customers;
import com.infosys.Customerrelationshipmanagement.beans.Interaction;
import com.infosys.Customerrelationshipmanagement.services.CRMServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class CustomerrelationshipmanagementApplication implements CommandLineRunner {

	@Autowired
	private CRMServices crmService;

	public static void main(String[] args) {
		SpringApplication.run(CustomerrelationshipmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 1 to Add new Customer");
		System.out.println("Enter 2 to View Customer");
		System.out.println("Enter 3 to Update Customer");
		System.out.println("Enter 4 to Delete Customer");
		System.out.println("Enter 5 to Add Interaction");
		System.out.println("Enter 6 to View Feedback by Product");
		System.out.println("Enter 7 to View Feedback by Date Range");
		System.out.println("Enter 8 to View Feedback by Rating");

		int operation = scanner.nextInt();
		scanner.nextLine(); // consume newline

		switch (operation) {
			case 1:
				Customers customer = new Customers();
				System.out.println("Enter Customer Name:");
				customer.setName(scanner.nextLine());
				System.out.println("Enter Customer Email:");
				customer.setEmail(scanner.nextLine());
				System.out.println("Enter Customer Phone:");
				customer.setPhone(scanner.nextLine());
				System.out.println("Enter Customer Address:");
				customer.setAddress(scanner.nextLine());
				crmService.addCustomer(customer);
				System.out.println("Customer added successfully.");
				break;

			case 2:
				System.out.println("1. View Customer by ID");
				System.out.println("2. View All Customers");
				int opt = scanner.nextInt();
				scanner.nextLine();

				if (opt == 1) {
					System.out.println("Enter Customer ID:");
					int id = scanner.nextInt();
					scanner.nextLine();
					try {
						Customers c = crmService.getCustomerById(id);
						System.out.println(c);
					} catch (Exception e) {
						System.err.println("Invalid ID: " + e.getMessage());
					}
				} else if (opt == 2) {
					try {
						List<Customers> allCustomers = crmService.getAllCustomer();
						allCustomers.forEach(System.out::println);
					} catch (Exception e) {
						System.out.println("Error fetching records: " + e.getMessage());
					}
				} else {
					System.out.println("Invalid option!");
				}
				break;

			case 3:
				System.out.println("Enter Customer ID to update:");
				int idToUpdate = scanner.nextInt();
				scanner.nextLine();
				try {
					Customers existing = crmService.getCustomerById(idToUpdate);
					if (existing == null) {
						System.out.println("Customer with ID " + idToUpdate + " not found.");
						break;
					}
					System.out.println("Enter new Name:");
					existing.setName(scanner.nextLine());
					System.out.println("Enter new Email:");
					existing.setEmail(scanner.nextLine());
					System.out.println("Enter new Phone:");
					existing.setPhone(scanner.nextLine());
					System.out.println("Enter new Address:");
					existing.setAddress(scanner.nextLine());
					crmService.updateCustomer(existing);
					System.out.println("Customer updated successfully.");
				} catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
				}
				break;

			case 4:
				System.out.println("Enter Customer ID to delete:");
				int delId = scanner.nextInt();
				scanner.nextLine();
				crmService.deleteCustomer(delId);
				System.out.println("Customer deleted successfully.");
				break;

			case 5:
				System.out.println("Enter Customer ID:");
				int custId = scanner.nextInt();
				scanner.nextLine();
				Interaction interaction = new Interaction();
				System.out.println("Enter Product:");
				interaction.setProduct(scanner.nextLine());
				System.out.println("Enter Rating (1-5):");
				interaction.setRating(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter Notes:");
				interaction.setNotes(scanner.nextLine());
				try {
					crmService.addInteraction(custId, interaction);
					System.out.println("Interaction added successfully.");
				} catch (Exception e) {
					System.out.println("Failed to add interaction: " + e.getMessage());
				}
				break;

			case 6:
				System.out.println("Enter Product Name:");
				String product = scanner.nextLine();
				List<Interaction> productFeedback = crmService.getFeedbackByProduct(product);
				productFeedback.forEach(System.out::println);
				break;

			case 7:
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				System.out.println("Enter Start Date (yyyy-MM-dd):");
				LocalDate startDate = LocalDate.parse(scanner.nextLine(), formatter);
				System.out.println("Enter End Date (yyyy-MM-dd):");
				LocalDate endDate = LocalDate.parse(scanner.nextLine(), formatter);
				List<Interaction> dateFeedback = crmService.getFeedbackByDateRange(startDate, endDate);
				dateFeedback.forEach(System.out::println);
				break;

			case 8:
				System.out.println("Enter Rating (1-5):");
				int rating = scanner.nextInt();
				scanner.nextLine();
				List<Interaction> ratingFeedback = crmService.getFeedbackByRating(rating);
				ratingFeedback.forEach(System.out::println);
				break;

			default:
				System.out.println("Invalid input!");
		}

		scanner.close();
	}
}
