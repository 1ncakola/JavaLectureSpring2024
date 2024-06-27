import java.util.Scanner;

public class Demo {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        library.addExamplePatrons();
        
        boolean exit = false;
        while (!exit) {
            // create switch statements for menu
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    editItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    borrowItem();
                    break;
                case 5:
                    returnItem();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
    // Create menu display
    private static void showMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Add new library item");
        System.out.println("2. Edit existing library item");
        System.out.println("3. Delete library item");
        System.out.println("4. Borrow library item");
        System.out.println("5. Return library item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    // Create add item function 
    private static void addItem() {
        System.out.println("Select item type:");
        System.out.println("1. Book");
        System.out.println("2. Periodical");
        int itemType = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter item ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter author date of birth: ");
        String dob = scanner.nextLine();
        Author author = new Author(authorName, dob);
        library.addAuthor(author);

        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter number of copies: ");
        int numCopies = scanner.nextInt();
        scanner.nextLine(); 

        if (itemType == 1) {
            System.out.print("Enter format (printed, electronic, audio): ");
            String format = scanner.nextLine();
            Book.BookType bookType = Book.BookType.valueOf(format.toUpperCase());
            Book book = new Book(id, title, author, ISBN, publisher, numCopies, bookType);
            library.addItem(book);
            author.addItem(book);
        } else if (itemType == 2) {
            System.out.print("Enter type (printed, electronic): ");
            String type = scanner.nextLine();
            Periodical.PeriodicalType periodicalType = Periodical.PeriodicalType.valueOf(type.toUpperCase());
            Periodical periodical = new Periodical(id, title, author, ISBN, publisher, numCopies, periodicalType);
            library.addItem(periodical);
            author.addItem(periodical);
        } else {
            System.out.println("Invalid item type.");
        }
        System.out.println("Item added.");
    }
    //Create edit item function
    private static void editItem() {
        System.out.print("Enter item ID to edit: ");
        String itemId = scanner.nextLine();

        LibraryItem item= library.searchItemById(itemId);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        System.out.println("Editing item: " + item.getTitle());
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        item.setTitle(title);

        System.out.print("Enter new publisher: ");
        String publisher = scanner.nextLine();
        item.setPublisher(publisher);

        System.out.print("Enter new number of copies: ");
        int numberOfCopies = scanner.nextInt();
        scanner.nextLine(); 
        item.setNumCopies(numberOfCopies);

        if (item instanceof Book) {
            System.out.print("Enter new format (printed, electronic, audio): ");
            String format = scanner.nextLine();
            Book.BookType bookType = Book.BookType.valueOf(format.toUpperCase());
            ((Book) item).setType(bookType);
        } else if (item instanceof Periodical) {
            System.out.print("Enter new type (printed, electronic): ");
            String type = scanner.nextLine();
            Periodical.PeriodicalType periodicalType = Periodical.PeriodicalType.valueOf(type.toUpperCase());
            ((Periodical) item).setType(periodicalType);
        }
        System.out.println("Item edited.");
    }
    //Create delete item function
    private static void deleteItem() {
        System.out.print("Enter item ID to delete: ");
        String itemId = scanner.nextLine();
        library.deleteItems(itemId);
        System.out.println("Item deleted.");
    }
    //Create borrow item function
    private static void borrowItem() {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        Patron patron = findPatronByName(patronName);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }
        System.out.print("Enter item ID to borrow: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 
        library.borrowItems(patron, itemId, quantity);
        System.out.println("Item borrowed.");
    }
    //Create return item function
    private static void returnItem() {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        Patron patron = findPatronByName(patronName);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }
        System.out.print("Enter item ID to return: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 
        library.returnItem(patron, itemId, quantity);
        System.out.println("Item returned.");
    }
    //Create if statement for Patron 
    private static Patron findPatronByName(String name) {
        for (Patron patron : library.getPatrons()) {
            System.out.println("Comparing: " + patron.getName() + " with " + name);
            if (patron.getName().equalsIgnoreCase(name.trim())) {
                return patron;
            }
        }
        System.out.println("Patron not found with name: " + name);
        return null;
    }
    
}