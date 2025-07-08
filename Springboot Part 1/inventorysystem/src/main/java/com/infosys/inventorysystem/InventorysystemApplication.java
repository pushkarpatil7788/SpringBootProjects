package com.infosys.inventorysystem;

import com.infosys.inventorysystem.beans.Products;
import com.infosys.inventorysystem.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class InventorysystemApplication implements CommandLineRunner {

	@Autowired
	ProductServices productServices;
	public static void main(String[] args) {
		SpringApplication.run(InventorysystemApplication.class ,args);
	}
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add new Product");
		System.out.println("Enter 2 to add multiple Product");
		System.out.println("Enter 3 to find the Product on basis of id");
		System.out.println("Enter 4 to update Product details");
		System.out.println("Enter 5 to remove Product");
		System.out.println("Enter 6 to view all Product");
		System.out.println("Enter 7 to view category to search ");
		System.out.println("Enter 8 to view min-max price");
		System.out.println("Enter your choise :-");
		int Operation =scanner.nextInt();

		switch (Operation) {
			case 1:
				System.out.println("Enter Product Name");
				String productName = scanner.next();
				System.out.println("Enter product Description ");
				String productDescription = scanner.next();
				System.out.println("Enter product price");
				double productPrice = scanner.nextDouble();
				System.out.println("Enter product StockQuantity");
				int ProductStockQuantity = scanner.nextInt();
				System.out.println("Enter product Category ");
				String productCategory = scanner.next();
				Products products1 = new Products();
				products1.setProductName(productName);
				products1.setProductDescription(productDescription);
				products1.setProductPrice(productPrice);
				products1.setProductStockQuantity(ProductStockQuantity);
				products1.setCategory(productCategory);
				productServices.addProducts(products1);
				break;

			case 2:
				System.out.println("How many Product do you want to add?");
				int noOfProductas = scanner.nextInt();
				List<Products> ProductsList = new ArrayList<>();
				for (int i = 0; i < noOfProductas; i++) {
					System.out.println("Enter Product Name");
					String productName1 = scanner.next();
					System.out.println("Enter product Description ");
					String productDescription1 = scanner.next();
					System.out.println("Enter product price");
					double productPrice1 = scanner.nextDouble();
					System.out.println("Enter product StockQuantity");
					int ProductStockQuantity1 = scanner.nextInt();
					System.out.println("Enter Product category");
					String category1=scanner.next();
					Products product2 = new Products();
					product2.setProductName(productName1);
					product2.setProductDescription(productDescription1);
					product2.setProductPrice(productPrice1);
					product2.setProductStockQuantity(ProductStockQuantity1);
					product2.setCategory(category1);
					ProductsList.add(product2);
				}
				productServices.addMultipleProducts(ProductsList);

			case 3:
				System.out.println("Enter ProductID to see Product details");
				int productId = scanner.nextInt();
				try {
					Optional<Products> optional = productServices.findProductById(productId);
					Products products = optional.get();
					System.out.println(products.toString());
				} catch (Exception e) {
					System.err.println("Id not found");
				}
				break;

			case 4:
				System.out.println("Enter ProductId to update:");
				int updateId = scanner.nextInt();
				Optional<Products> optionalProducts = productServices.findProductById(updateId);
				if (optionalProducts.isPresent()) {
					Products existingProduct = optionalProducts.get();
					System.out.println("Existing Details:");
					System.out.println("ProductName: " + existingProduct.getProductName());
					System.out.println("ProductDescription: " + existingProduct.getProductDescription());
					System.out.println("ProductPrice: " + existingProduct.getProductPrice());
					System.out.println("ProductStockQuantity:" + existingProduct.getProductStockQuantity());
					System.out.println("Catrgory:"+existingProduct.getCategory());
					System.out.println("Enter new ProductName:");
					String newName = scanner.next();
					System.out.println("Enter new ProductDescription:");
					String newDescription = scanner.next();
					System.out.println("Enter new ProductPrice:");
					Double newPrice = scanner.nextDouble();
					System.out.println("Enter new ProductStockQuantity:");
					int newStockQuantity = scanner.nextInt();
					System.out.println("Enter Product category");
					String newcategory = scanner.next();

					existingProduct.setProductName(newName);
					existingProduct.setProductDescription(newDescription);
					existingProduct.setProductPrice(newPrice);
					existingProduct.setProductStockQuantity(newStockQuantity);
					existingProduct.setCategory(newcategory);
					productServices.updateProduct(existingProduct);
					System.out.println("product updated successfully.");
				}else {
					System.out.println("Product not found with ID: " + updateId);
				}
				break;

			case 5:
				System.out.println("Enter Product ID to delete:");
				int deleteId = scanner.nextInt();
				try {
					productServices.deleteProduct(deleteId);
					System.out.println("Product deleted successfully.");
				} catch (Exception e) {
					System.out.println("Failed to delete. ID may not exist.");
				}
				break;

			case 6:
				List<Products> allProducts = productServices.getAllProducts();
				if (allProducts.isEmpty()) {
					System.out.println("No Products found.");
				} else {
					System.out.println("All Products:");
					for (Products p : allProducts) {
						System.out.println(p);
					}
				}
				break;

			case 7:
				System.out.println("Enter category to search:");
				String category = scanner.next();
				List<Products> byCategory = productServices.getProductsByCategory(category);
				if (byCategory.isEmpty()) {
					System.out.println("No products found in this category.");
				} else {
					byCategory.forEach(System.out::println);
				}
				break;

			case 8:
				System.out.println("Enter min price:");
				double min = scanner.nextDouble();
				System.out.println("Enter max price:");
				double max = scanner.nextDouble();
				List<Products> byPrice = productServices.getProductsByPriceRange(min, max);
				byPrice.forEach(System.out::println);
				break;



			default:
				System.out.println("Please select valid operation. Thank you!");

		}
	}

}
