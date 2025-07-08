package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.beans.Author;
import com.example.LibraryManagementSystem.beans.Book;
import com.example.LibraryManagementSystem.beans.LibraryBranch;
import com.example.LibraryManagementSystem.beans.Publisher;
import com.example.LibraryManagementSystem.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class LibraryManagementSystemApplication implements CommandLineRunner {

	@Autowired
	BookService bookService;
	@Autowired
	AuthorService authorService;
	@Autowired
	LibraryBranchService libraryBranchService;
	@Autowired
	PublisherService publisherService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 1 to Add a Book");
		System.out.println("Enter 2 to Find Book by ID");
		System.out.println("Enter 3 to Update a Book");
		System.out.println("Enter 4 to Delete a Book");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				scanner.nextLine(); // clear buffer
				System.out.println("Enter Book Title:");
				String title = scanner.nextLine();
				System.out.println("Enter Publisher Name:");
				String publisherName = scanner.nextLine();
				Publisher publisher = new Publisher();
				publisher.setPublisherName(publisherName);
				publisher = publisherService.addPublisher(publisher);
				List<Author> authors = new ArrayList<>();
				System.out.println("Enter number of Authors:");
				int authorCount = scanner.nextInt();
				scanner.nextLine();
				for (int i = 0; i < authorCount; i++) {
					System.out.println("Enter Author Name:");
					String authName = scanner.nextLine();
					Author newAuthor = new Author();
					newAuthor.setAuthorName(authName);
					authorService.addAuthor(newAuthor);
					authors.add(newAuthor);
				}
				List<LibraryBranch> branches = new ArrayList<>();
				System.out.println("Enter number of Library Branches:");
				int branchCount = scanner.nextInt();
				scanner.nextLine();
				for (int i = 0; i < branchCount; i++) {
					System.out.println("Enter Branch Name:");
					String branchName = scanner.nextLine();
					LibraryBranch newBranch = new LibraryBranch();
					newBranch.setLibraryBranchName(branchName);
					libraryBranchService.addLibraryBranch(newBranch);
					branches.add(newBranch);
				}
				Book book = new Book();
				book.setBookTitle(title);
				book.setPublisher(publisher);
				book.setAuthors(authors);
				book.setBranches(branches);
				bookService.addBook(book);
				System.out.println("Book added successfully!");
				break;

			case 2:
				System.out.println("Enter Book ID:");
				int id = scanner.nextInt();
				bookService.findBookById(id).ifPresentOrElse(
						System.out::println,
						() -> System.out.println("Book not found.")
				);
				break;

			case 3:
				System.out.println("Enter Book ID to update:");
				int updateId = scanner.nextInt();
				Optional<Book> bookOpt = bookService.findBookById(updateId);

				if (bookOpt.isPresent()) {
					scanner.nextLine();
					Book bookToUpdate = bookOpt.get();
					System.out.println("Enter new Book Title:");
					String newTitle = scanner.nextLine();
					bookToUpdate.setBookTitle(newTitle);

					System.out.println("Enter new Publisher ID:");
					int newPublisherId = scanner.nextInt();
					scanner.nextLine();
					Optional<Publisher> publisherOpt = publisherService.findPublisherById(newPublisherId);
					if (publisherOpt.isPresent()) {
						bookToUpdate.setPublisher(publisherOpt.get());
					} else {
						System.out.println("Publisher not found. Skipping publisher update.");
					}

					System.out.println("Enter comma-separated Author IDs (e.g. 1,2,3):");
					String authorIdsStr = scanner.nextLine();
					List<Author> newAuthors = new ArrayList<>();
					for (String idStr : authorIdsStr.split(",")) {
						try {
							int authorId = Integer.parseInt(idStr.trim());
							Optional<Author> authorOpt = authorService.findAuthorById(authorId);
							authorOpt.ifPresent(newAuthors::add);
						} catch (NumberFormatException e) {
							System.out.println("Invalid Author ID: " + idStr);
						}
					}
					if (!newAuthors.isEmpty()) {
						bookToUpdate.setAuthors(newAuthors);
					} else {
						System.out.println("No valid authors found. Skipping authors update.");
					}

					System.out.println("Enter comma-separated Library Branch IDs (e.g. 1,2,3):");
					String branchIdsStr = scanner.nextLine();
					List<LibraryBranch> newBranches = new ArrayList<>();
					for (String idStr : branchIdsStr.split(",")) {
						try {
							int branchId = Integer.parseInt(idStr.trim());
							Optional<LibraryBranch> branchOpt = libraryBranchService.findLibraryBranchById(branchId);
							branchOpt.ifPresent(newBranches::add);
						} catch (NumberFormatException e) {
							System.out.println("Invalid Branch ID: " + idStr);
						}
					}
					if (!newBranches.isEmpty()) {
						bookToUpdate.setBranches(newBranches);
					} else {
						System.out.println("No valid branches found. Skipping branches update.");
					}

					bookService.updateBook(bookToUpdate);
					System.out.println("Book updated successfully.");
				} else {
					System.out.println("Book not found.");
				}
				break;

			case 4:
				System.out.println("Enter Book ID to delete:");
				int delId = scanner.nextInt();
				bookService.deleteBook(delId);
				System.out.println("Book deleted successfully.");
				break;

			default:
				System.out.println("Invalid choice. Please enter between 1 to 4.");
		}
	}
}