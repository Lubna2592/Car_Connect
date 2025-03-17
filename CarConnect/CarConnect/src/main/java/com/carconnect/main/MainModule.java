package com.carconnect.main;

import com.carconnect.service.*;
import com.carconnect.entity.*;
import com.carconnect.exception.*;

import java.util.Scanner;

public class MainModule {
    private static final CustomerService customerService = new CustomerService();
    private static final AdminService adminService = new AdminService();
    private static final VehicleService vehicleService = new VehicleService();
    private static final ReservationService reservationService = new ReservationService();
    private static final PaymentService paymentService = new PaymentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCarConnect System Menu:");
            System.out.println("1. Customer Operations");
            System.out.println("2. Admin Operations");
            System.out.println("3. Vehicle Management");
            System.out.println("4. Reservation Management");
            System.out.println("5. Payment Processing");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: manageCustomers(); break;
                case 2: manageAdmins(); break;
                case 3: manageVehicles(); break;
                case 4: manageReservations(); break;
                case 5: processPayments(); break;
                case 6: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void manageCustomers() {
        System.out.println("1. Register Customer");
        System.out.println("2. Get Customer by ID");
        System.out.println("3. Get Customer by Username");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1 : {
            	    System.out.print("Enter CustomerID: ");
        	        int CustomerID = scanner.nextInt();
            	    
            	    System.out.print("Enter First Name: ");
            	    String firstName = scanner.nextLine();
            	    
            	    System.out.print("Enter Last Name: ");
            	    String lastName = scanner.nextLine();
            	    
            	    System.out.print("Enter Username: ");
            	    String username = scanner.nextLine();
            	    
            	    System.out.print("Enter Password: ");
            	    String password = scanner.nextLine();
            	    
            	    System.out.print("Enter Email: ");
            	    String email = scanner.nextLine();
            	    
            	    System.out.print("Enter Phone Number: ");
            	    String phoneNumber = scanner.nextLine();

            	    System.out.print("Enter Address: ");
            	    String Address = scanner.nextLine();
            	    Customer newCustomer = new Customer(CustomerID, firstName, lastName, email, phoneNumber, Address, username, password);

            	    try {
            	        customerService.registerCustomer(newCustomer);
            	        System.out.println("Customer Registered Successfully!");
            	    } catch (Exception e) {
            	        System.out.println("Error Registering Customer: " + e.getMessage());
            	    }
            }
            case 2 : {
                System.out.print("Enter Customer ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                try {
                    Customer customer = customerService.getCustomerById(id);
                    System.out.println("Customer Found: " + customer.getFirstName() + " " + customer.getLastName());
                } catch (CustomerNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 3 : {
                System.out.print("Enter Customer Username: ");
                String username = scanner.nextLine();
                try {
                    Customer customer = customerService.getCustomerByUsername(username);
                    System.out.println("Customer Found: " + customer.getFirstName() + " " + customer.getLastName());
                } catch (CustomerNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            default : System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }


    private static void manageAdmins() {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        try {
            Admin admin = adminService.getAdminByUsername(username);
            System.out.println("Admin Found: " + admin.getFirstName() + " " + admin.getLastName());
        } catch (AdminNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void manageVehicles() {
        System.out.println("1. Get Vehicle by ID");
        System.out.println("2. Get Vehicle by Model");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.print("Enter Vehicle ID: ");
            int id = scanner.nextInt();
            try {
                Vehicle vehicle = vehicleService.getVehicleById(id);
                System.out.println("Vehicle Found: " + vehicle.getMake() + " " + vehicle.getModel());
            } catch (VehicleNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else if (choice == 2) {
            System.out.print("Enter Vehicle Model: ");
            String model = scanner.nextLine();
            try {
                Vehicle vehicle = vehicleService.getVehicleByModel(model);
                System.out.println("Vehicle Found: " + vehicle.getMake() + " " + vehicle.getModel());
            } catch (VehicleNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void manageReservations() {
        System.out.print("Enter Reservation ID: ");
        int id = scanner.nextInt();
        try {
            Reservation reservation = reservationService.getReservationById(id);
            System.out.println("Reservation Found: " + reservation.getStatus());
        } catch (ReservationException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processPayments() {
        System.out.print("Enter Reservation ID for Payment: ");
        int reservationID = scanner.nextInt();
        System.out.print("Enter Payment Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Payment Method (Credit Card, PayPal, etc.): ");
        String paymentMethod = scanner.nextLine();
        boolean success = paymentService.processPayment(reservationID, amount, paymentMethod);
        if (success) {
            System.out.println("Payment processed successfully.");
        } else {
            System.out.println("Payment failed.");
        }
    }
}

