import java.util.ArrayList;
import java.util.List;
//Create public class for library
public class Library {
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    // Methods for adding items, authors, and patrons
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

   


    // Methods for editing and deleting items, authors, and patrons
    public void editItems(String id, LibraryItem newItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.set(i, newItem);
                return;
            }
        }
    }

    public void deleteItems(String id) {
        items.removeIf(item -> item.getId().equals(id));
    }

    // Methods for borrowing and returning items
    public void borrowItems(Patron patron, String itemId, int quantity) {
        for (LibraryItem item : items) {
            if (item.getId().equals(itemId) && item.getNumCopies() >= quantity) {
                item.setNumCopies(item.getNumCopies() - quantity);
                for (int i = 0; i < quantity; i++) {
                    patron.addBorrowedItem(item);
                }
                return;
            }
        }
        System.out.println("Item not available or insufficient copies.");
    }

    public void returnItem(Patron patron, String itemId, int quantity) {
        List<LibraryItem> toRemove = new ArrayList<>();
        for (LibraryItem borrowedItem : patron.getBorrowedItems()) {
            if (borrowedItem.getId().equals(itemId)) {
                toRemove.add(borrowedItem);
                if (toRemove.size() == quantity) break;
            }
        }
        if (toRemove.size() < quantity) {
            System.out.println("You cannot return more items than you borrowed.");
            return;
        }
        patron.getBorrowedItems().removeAll(toRemove);
        for (LibraryItem item : items) {
            if (item.getId().equals(itemId)) {
                item.setNumCopies(item.getNumCopies() + quantity);
                break;
            }
        }
    }

    // Methods for searching items
    public LibraryItem searchItemByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public LibraryItem searchItemByAuthor(String authorName) {
        for (LibraryItem item : items) {
            if (item.getAuthor().getName().equalsIgnoreCase(authorName)) {
                return item;
            }
        }
        return null;
    }

    public LibraryItem searchItemByISBN(String ISBN) {
        for (LibraryItem item : items) {
            if (item.getISBN().equalsIgnoreCase(ISBN)) {
                return item;
            }
        }
        return null;
    }

    public LibraryItem searchItemById(String Id) {
        for (LibraryItem item : items) {
            if (item.getId().equalsIgnoreCase(Id)) {
                return item;
            }
        }
        return null;
    }
    // Create public for patron
    public Patron[] getPatrons() {
        return patrons.toArray(new Patron[0]);
    }


    public void addExamplePatrons() {
        Patron patron1 = new adultpatron("John Doe", "123 Main St", "555-1234");
        addPatron(patron1);

        Patron patron2 = new adultpatron("Jane Smith", "456 Elm St", "555-5678");
        addPatron(patron2);
    }

}