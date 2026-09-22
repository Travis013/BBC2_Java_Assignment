package library;

/**
 * ============================================================================
 * BBC 2 - OOP JAVA PROGRAMMING GROUP ASSIGNMENT
 * Project: Library Book Checkout System
 * 
 * GROUP MEMBERS & CONTRIBUTIONS:
 * 1. Luboobi Jonathan  Do-While Loop & Main Menu Structure
 * 2. Kanyi Margaret        - For Loop & Book Inventory List
 * 3. Nabwire Zainah        - Ternary Statements for Book Status
 * 4. Kagoya Shanita        - While Loop & User Input Validation
 * 5. Pheni Travis Jeremiah     - GitHub Repository Setup & Documentation
 * ============================================================================
 */

import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pre-defined inventory of books
        String[] books = {"Java Programming", "Data Structures", "Database Systems", "Web Development"};
        boolean[] isBorrowed = {false, false, false, false};

        System.out.println("==========================================");
        System.out.println("   WELCOME TO THE BBC 2 LIBRARY SYSTEM    ");
        System.out.println("==========================================");

        int choice;

        // 1. DO-WHILE LOOP: Keeps the main menu running until the user chooses to exit
        // Developed by: luboobi Jonathan
        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- BOOK INVENTORY ---");
                    // 2. FOR LOOP & 3. TERNARY STATEMENT
                    // Developed by: Kanyi Margaret & Nabwire Zainah
                    for (int i = 0; i < books.length; i++) {
                        String status = isBorrowed[i] ? "Borrowed" : "Available";
                        System.out.println((i + 1) + ". " + books[i] + " [" + status + "]");
                    }
                    break;

                case 2:
                    System.out.println("\n--- BORROW A BOOK ---");
                    int bookNumber = -1;

                    // 4. WHILE LOOP: Validates user input
                    // Developed by: Kagoya Shanita
                    while (bookNumber < 1 || bookNumber > books.length) {
                        System.out.print("Enter book number (1-" + books.length + "): ");
                        bookNumber = scanner.nextInt();

                        if (bookNumber < 1 || bookNumber > books.length) {
                            System.out.println("Invalid number! Please try again.");
                        }
                    }

                    int index = bookNumber - 1;

                    if (isBorrowed[index]) {
                        System.out.println("Sorry, \"" + books[index] + "\" is already borrowed.");
                    } else {
                        isBorrowed[index] = true;
                        System.out.println("Success! You have borrowed \"" + books[index] + "\".");
                    }
                    break;

                case 3:
                    System.out.println("\nThank you for using the Library System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid selection! Please choose an option between 1 and 3.");
            }

        } while (choice != 3);

        scanner.close();
    }
}