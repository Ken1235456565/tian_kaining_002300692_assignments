package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Author;
import model.AuthorDirectory;
import model.Book;
import model.Branch;
import model.Customer;
import model.CustomerDirectory;
import model.Library;
import model.Profile;
import model.Role;
import model.User;
import model.UserDirectory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class APP {
    // Singleton instance
    private static APP instance;

    // Class attributes
    private List<Branch> branches;
    private UserDirectory userDirectory;
    private CustomerDirectory customerDirectory;
    private AuthorDirectory authorDirectory;
    private Library mainLibrary;

    // Private constructor to prevent instantiation
    public APP() {
        this.userDirectory = new UserDirectory();
        this.customerDirectory = new CustomerDirectory();
        this.authorDirectory = new AuthorDirectory();
        this.mainLibrary = new Library("Main Library");
        this.branches = new ArrayList<>();
    }

    // Singleton pattern method to get the instance
    public static APP getInstance() {
        if (instance == null) {
            instance = new APP();
            instance.configureBusiness(); // Initialize with sample data
        }
        return instance;
    }

    // Method to initialize sample data
    public void configureBusiness() {
        // Create roles
        Role adminRole = new Role("Admin");
        Role managerRole = new Role("Branch Manager");
        Role customerRole = new Role("Customer");

        // === Admin user: 1 / 1 ===
        Profile adminProfile = new Profile(adminRole, "ADMIN001");
        User adminUser = new User(adminProfile, "1", "1");
        userDirectory.addUser(adminUser);

        // === Branch Manager user: 2 / 2 ===
        Profile manager1Profile = new Profile(managerRole, "BM001");
        User manager1 = new User(manager1Profile, "2", "2");
        userDirectory.addUser(manager1);

        // === Branch with manager "2" ===
        Library lib1 = new Library("Central Library");
        Branch branch1 = new Branch("B001", "Downtown Branch", lib1, "2");
        branches.add(branch1);

        // === Branch 2 & manager 2 (optional second branch) ===
        Library lib2 = new Library("East Library");
        Branch branch2 = new Branch("B002", "Eastside Branch", lib2, "2");
        branches.add(branch2);

        // === Customer user: 3 / 3 ===
        Profile cust1Profile = new Profile(customerRole, "C001");
        User cust1User = new User(cust1Profile, "3", "3");
        userDirectory.addUser(cust1User);  // 确保将用户添加到 userDirectory
        Customer cust1 = new Customer("C001", cust1User);
        customerDirectory.addCustomer(cust1);

        // === Optional extra customers ===
        Profile cust2Profile = new Profile(customerRole, "C002");
        User cust2User = new User(cust2Profile, "customer2", "pass123");
        userDirectory.addUser(cust2User);  // 确保将用户添加到 userDirectory
        Customer cust2 = new Customer("C002", cust2User);
        customerDirectory.addCustomer(cust2);

        Profile cust3Profile = new Profile(customerRole, "C003");
        User cust3User = new User(cust3Profile, "customer3", "pass123");
        userDirectory.addUser(cust3User);  // 确保将用户添加到 userDirectory
        Customer cust3 = new Customer("C003", cust3User);
        customerDirectory.addCustomer(cust3);

        // === Authors ===
        Author author1 = new Author("A001", "George Orwell", new Date(), "British");
        Author author2 = new Author("A002", "J.K. Rowling", new Date(), "British");
        Author author3 = new Author("A003", "Stephen King", new Date(), "American");
        Author author4 = new Author("A004", "Jane Austen", new Date(), "British");
        Author author5 = new Author("A005", "Mark Twain", new Date(), "American");

        authorDirectory.addAuthor(author1);
        authorDirectory.addAuthor(author2);
        authorDirectory.addAuthor(author3);
        authorDirectory.addAuthor(author4);
        authorDirectory.addAuthor(author5);

        // === Books ===
        Book book1 = new Book("B001", "1984", new Date(), 328, "English", author1);
        book1.setRentalPricePerDay(3.50);

        Book book2 = new Book("B002", "Harry Potter", new Date(), 223, "English", author2);
        book2.setRentalPricePerDay(4.00);

        Book book3 = new Book("B003", "The Shining", new Date(), 447, "English", author3);
        book3.setRentalPricePerDay(3.75);

        Book book4 = new Book("B004", "Pride and Prejudice", new Date(), 432, "English", author4);
        book4.setRentalPricePerDay(2.50);

        Book book5 = new Book("B005", "Adventures of Tom Sawyer", new Date(), 366, "English", author5);
        book5.setRentalPricePerDay(2.75);

        lib1.addBook(book1);
        lib1.addBook(book2);
        lib1.addBook(book3);

        lib2.addBook(book4);
        lib2.addBook(book5);

        // === Rental Requests ===
        RentalRequest request1 = new RentalRequest(cust1, book1, lib1, 7, 24.50);
        request1.updateStatus("APPROVED");
        cust1.addRentalRequest(request1);
        branch1.addRentalRequest(request1);

        RentalRequest request2 = new RentalRequest(cust2, book4, lib2, 5, 12.50);
        request2.updateStatus("PENDING");
        cust2.addRentalRequest(request2);
        branch2.addRentalRequest(request2);
    }

    // Getters
    public UserDirectory getUserDirectory() {
        return userDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public AuthorDirectory getAuthorDirectory() {
        return authorDirectory;
    }

    public Library getMainLibrary() {
        return mainLibrary;
    }

    public List<Branch> getBranches() {
        return branches;
    }
}