import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LibraryApp {
    private List<Book> books;
    private Scanner scanner;

    public LibraryApp() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    printAllBooks();
                    break;
                case "2":
                    addNewBook();
                    break;
                case "3":
                    searchBooksByTitle();
                    break;
                case "4":
                    borrowBook();
                    break;
                case "5":
                    returnBook();
                    break;
                case "6":
                    deleteBookById();
                    break;
                case "7":
                    System.out.println("Exiting Library App. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("=== Welcome to Library App! ===");
        System.out.println("1. Print all books");
        System.out.println("2. Add new book");
        System.out.println("3. Search books by title");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Delete a book by id");
        System.out.println("7. Quit");
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void addNewBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year;
        try {
            year = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year. Book not added.");
            return;
        }

        try {
            Book newBook = new Book(title, author, year);
            books.add(newBook);
            System.out.println("Book added: " + newBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchBooksByTitle() {
        System.out.print("Enter part of the title to search: ");
        String query = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found matching that title.");
        }
    }

    private void borrowBook() {
        System.out.print("Enter book ID to borrow: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isAvailable()) {
            System.out.println("The book is already borrowed.");
        } else {
            book.markAsBorrowed();
            System.out.println("You borrowed: " + book);
        }
    }

    private void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isAvailable()) {
            System.out.println("This book was not borrowed.");
        } else {
            book.markAsReturned();
            System.out.println("Book returned: " + book);
        }
    }

    private void deleteBookById() {
        System.out.print("Enter book ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else {
            books.remove(book);
            System.out.println("Book deleted: " + book);
        }
    }


    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }


    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }

}
