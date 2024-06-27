import java.util.ArrayList;
import java.util.List;

//Create public class for Author
public class Author {
    private String name;
    private String dateOfBirth;
    private List<LibraryItem> itemsWritten;

    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.itemsWritten = new ArrayList<>();
    }
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<LibraryItem> getItemsWritten() {
        return itemsWritten;
    }

    //Constructor 
    public void addItem(LibraryItem item) {
        itemsWritten.add(item);
    }

    public void removeItem(LibraryItem item) {
        itemsWritten.remove(item);
    }
}