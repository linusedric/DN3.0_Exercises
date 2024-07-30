import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}


class Library {
    private Book[] books;
    private int count;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }


    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("Library capacity is full. Cannot add any more books.");
        }
    }


    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }


    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, 0, count, (a, b) -> a.title.compareToIgnoreCase(b.title));
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void displayAllBooks() {
        for (int i = 0; i < count; i++) {
            books[i].displayBook();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Library library = new Library(100); // Assume the library can hold up to 100 books
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display All Books");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Title (Binary Search)");
            System.out.println("4. Add a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Displaying all the books:");
                    library.displayAllBooks();
                    break;

                case 2:
                    System.out.print("Enter the book title to search (Linear Search): ");
                    String linearTitle = scanner.nextLine();
                    Book foundBookLinear = library.linearSearchByTitle(linearTitle);
                    if (foundBookLinear != null) {
                        foundBookLinear.displayBook();
                    } else {
                        System.out.println("Book with titel"+ linearTitle+" is not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the book title to search (Binary Search): ");
                    String binaryTitle = scanner.nextLine();
                    Book foundBookBinary = library.binarySearchByTitle(binaryTitle);
                    if (foundBookBinary != null) {
                        foundBookBinary.displayBook();
                    } else {
                        System.out.println("Book with title" + binaryTitle + "is not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter the Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the Author name: ");
                    String author = scanner.nextLine();

                    Book newBook = new Book(bookId, title, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;

                case 5:
                    System.out.println("Exiting Library Management System");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.choose from the available choices");
            }
        }
    }
}

