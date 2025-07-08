package com.infosys.EcommerceSystem;

import com.infosys.EcommerceSystem.beans.*;
import com.infosys.EcommerceSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class EcommerceSystemApplication implements CommandLineRunner {

	@Autowired
	private CactrgoryService cactrgoryService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 1 to Add an Order");
		System.out.println("Enter 2 to Find Order by ID");
		System.out.println("Enter 3 to Update an Order");
		System.out.println("Enter 4 to Delete an Order");
		System.out.println("Enter 5 to Fetch User with Profile and Orders");
		System.out.println("Enter 6 to Fetch Product with Categories");
		System.out.println("Enter 7 to Fetch Category with Products");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				scanner.nextLine();
				System.out.println("Enter Category Name:");
				String categoryName = scanner.nextLine();
				Category category = new Category();
				category.setCategoryName(categoryName);
				cactrgoryService.addCategory(category);
				System.out.println("Enter Product Name:");
				String productName = scanner.nextLine();
				System.out.println("Enter Product Price:");
				double productPrice = scanner.nextDouble();
				scanner.nextLine();
				Product product = new Product();
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				product.setCategories(List.of(category));
				productService.addProduct(product);

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

				User user = new User();
				user.setUsername(username);
				user.setUserPassword(password);
				Profile profile = new Profile();
				profile.setFirstName(firstName);
				profile.setLastName(lastName);
				profile.setEmail(email);
				profile.setUser(user);
				user.setProfile(profile);
				userService.addUser(user);
				Order order = new Order();
				order.setOrderDate(LocalDate.now());
				order.setUser(user);
				order.setProducts(List.of(product));
				orderService.addOrder(order);
				System.out.println("Order added successfully!");
				break;

			case 2:
				System.out.println("Enter Order ID:");
				int findId = scanner.nextInt();
				Order found = orderService.getOrderById(findId);
				if (found != null) {
					System.out.println(found);
				} else {
					System.out.println("Order not found.");
				}
				break;

			case 3:
				System.out.println("Enter Order ID to update:");
				int updateId = scanner.nextInt();
				scanner.nextLine();
				Order existingOrder = orderService.getOrderById(updateId);

				if (existingOrder != null) {
					System.out.println("Enter new Product Name:");
					String newProductName = scanner.nextLine();
					System.out.println("Enter new Product Price:");
					double newProductPrice = scanner.nextDouble();
					scanner.nextLine();
					Product newProduct = new Product();
					newProduct.setProductName(newProductName);
					newProduct.setProductPrice(newProductPrice);
					newProduct.setCategories(existingOrder.getProducts().get(0).getCategories());
					productService.addProduct(newProduct);
					existingOrder.setProducts(List.of(newProduct));
					existingOrder.setOrderDate(LocalDate.now());
					orderService.updateOrder(updateId, existingOrder);
					System.out.println("Order updated successfully.");
				} else {
					System.out.println("Order not found.");
				}
				break;

			case 4:
				System.out.println("Enter Order ID to delete:");
				int deleteId = scanner.nextInt();
				Order order1 = orderService.getOrderById(deleteId);
				if (order1 != null) {
					User user1 = order1.getUser();
					Profile profile1 = user1.getProfile();
					List<Product> products = order1.getProducts();
					List<Category> categories = new ArrayList<>();
					for (Product p : products) {
						categories.addAll(p.getCategories());
					}
					orderService.deleteOrder(deleteId);
					for (Product p : products) {
						productService.deleteProduct(p.getProductId());
					}
					profileService.deleteProfile(profile1.getProfileId());
					userService.deleteUser(user1.getUserId());
					for (Category c : categories) {
						cactrgoryService.deleteCategory(c.getCategoryId());
					}
					System.out.println("Order and related data deleted successfully.");
				} else {
					System.out.println("Order not found.");
				}
				break;

			case 5:
				System.out.print("Enter User ID: ");
				int uid = scanner.nextInt();
				User userWithDetails = userService.getUserWithProfileAndOrders(uid);
				if (userWithDetails != null) {
					System.out.println("User: " + userWithDetails.getUsername());
					if (userWithDetails.getProfile() != null) {
						System.out.println("Profile: " + userWithDetails.getProfile().getFirstName() + " " + userWithDetails.getProfile().getLastName());
					}
					System.out.println("Orders:");
					for (Order o : userWithDetails.getOrders()) {
						System.out.println("Order ID: " + o.getOrderId() + ", Date: " + o.getOrderDate());
					}
				} else {
					System.out.println("User not found.");
				}
				break;

			case 6:
				System.out.print("Enter Product ID: ");
				int pid = scanner.nextInt();
				Product prod = productService.getProductWithCategories(pid);
				if (prod != null) {
					System.out.println("Product: " + prod.getProductName() + ", Price: " + prod.getProductPrice());
					System.out.println("Categories:");
					for (Category cat : prod.getCategories()) {
						System.out.println(" - " + cat.getCategoryName());
					}
				} else {
					System.out.println("Product not found.");
				}
				break;

			case 7:
				System.out.print("Enter Category ID: ");
				int cid = scanner.nextInt();
				Category categoryWithProducts = cactrgoryService.getCategoryWithProducts(cid);
				if (categoryWithProducts != null) {
					System.out.println("Category: " + categoryWithProducts.getCategoryName());
					System.out.println("Products:");
					for (Product p : categoryWithProducts.getProducts()) {
						System.out.println(" - " + p.getProductName() + ", Price: " + p.getProductPrice());
					}
				} else {
					System.out.println("Category not found.");
				}
				break;

			default:
				System.out.println("Invalid choice. Please enter between 1 to 7.");
		}
	}
}
