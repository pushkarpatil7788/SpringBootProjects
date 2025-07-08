package com.vedant.Ecommerce;

import com.vedant.Ecommerce.beans.Product;
import com.vedant.Ecommerce.beans.Profile;
import com.vedant.Ecommerce.beans.User;
import com.vedant.Ecommerce.services.OrderServiceInterface;
import com.vedant.Ecommerce.services.ProductServiceInterface;
import com.vedant.Ecommerce.services.UserServiceInterface;

import com.vedant.Ecommerce.beans.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	UserServiceInterface userService;

	@Autowired
	OrderServiceInterface orderService;

	@Autowired
	ProductServiceInterface productService;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 1 to Create User with Profile");
		System.out.println("Enter 2 to Create Order for a User");
		System.out.println("Enter 3 to Assign Categories to Product");
		System.out.println("Enter 4 to Fetch User with Profile and Orders");
		System.out.println("Enter 5 to Fetch Product with Categories");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				scanner.nextLine();
				System.out.println("Enter Username:");
				String username = scanner.nextLine();
				System.out.println("Enter Password:");
				String password = scanner.nextLine();

				System.out.println("Enter First Name:");
				String firstName = scanner.nextLine();
				System.out.println("Enter Last Name:");
				String lastName = scanner.nextLine();
				System.out.println("Enter Email:");
				String email = scanner.nextLine();
				System.out.println("Enter Phone:");
				String phone = scanner.nextLine();
				System.out.println("Enter Address:");
				String address = scanner.nextLine();

				User user = new User();
				user.setUsername(username);
				user.setPassword(password);

				Profile profile = new Profile();
				profile.setFirstName(firstName);
				profile.setLastName(lastName);
				profile.setEmail(email);
				profile.setPhone(phone);
				profile.setAddress(address);

				userService.createUserWithProfile(user, profile);
				System.out.println("User with Profile created successfully.");
				break;

			case 2:
				System.out.println("Enter User ID:");
				int userId = scanner.nextInt();

				System.out.println("Enter number of Product IDs to add in the order:");
				int productCount = scanner.nextInt();
				List<Integer> productIds = new ArrayList<>();
				for (int i = 0; i < productCount; i++) {
					System.out.print("Enter Product ID " + (i + 1) + ": ");
					productIds.add(scanner.nextInt());
				}

				Order order = orderService.createOrderForUser(userId, productIds);
				System.out.println("Order created successfully with ID: " + order.getOrderId());
				break;

			case 3:
				System.out.println("Enter Product ID:");
				int productId = scanner.nextInt();

				System.out.println("Enter number of Category IDs to assign:");
				int catCount = scanner.nextInt();
				List<Integer> categoryIds = new ArrayList<>();
				for (int i = 0; i < catCount; i++) {
					System.out.print("Enter Category ID " + (i + 1) + ": ");
					categoryIds.add(scanner.nextInt());
				}

				Product updatedProduct = productService.assignCategoriesToProduct(productId, categoryIds);
				System.out.println("Product updated with categories successfully. Product Name: " + updatedProduct.getProductName());
				break;

			case 4:
				System.out.print("Enter User ID to fetch: ");
				int fetchUserId = scanner.nextInt();
				User fetchedUser = userService.getUserById(fetchUserId);

				if (fetchedUser != null) {
					System.out.println("Username: " + fetchedUser.getUsername());
					Profile userProfile = fetchedUser.getProfile();
					if (userProfile != null) {
						System.out.println("Profile - Name: " + userProfile.getFirstName() + " " + userProfile.getLastName());
						System.out.println("Email: " + userProfile.getEmail());
						System.out.println("Phone: " + userProfile.getPhone());
						System.out.println("Address: " + userProfile.getAddress());
					}

					System.out.println("Orders:");
					fetchedUser.getOrders().forEach(o -> {
						System.out.println(" - Order ID: " + o.getOrderId());
						o.getProducts().forEach(p -> System.out.println("   * Product: " + p.getProductName()));
					});
				} else {
					System.out.println("User not found.");
				}
				break;

			case 5:
				System.out.print("Enter Product ID to fetch: ");
				int fetchProductId = scanner.nextInt();
				Product product = productService.getProductById(fetchProductId);

				if (product != null) {
					System.out.println("Product Name: " + product.getProductName());
					System.out.println("Price: " + product.getProductPrice());
					System.out.println("Categories:");
					product.getCategories().forEach(c -> System.out.println(" - " + c.getCategoryName()));
				} else {
					System.out.println("Product not found.");
				}
				break;

			default:
				System.out.println("Invalid choice.");
		}
	}
}
