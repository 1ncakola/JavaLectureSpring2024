import java.util.ArrayList;
import java.util.List;
//Create a public class for patronlist
public class patronlist {
    private List<Patron> patrons;

    public patronlist() {
        this.patrons = new ArrayList<>();
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void editPatron(String name, String newName, String newAddress, String newPhoneNumber) {
        for (Patron patron : patrons) {
            if (patron.getName().equals(name)) {
                patron.setName(newName);
                patron.setAddress(newAddress);
                patron.setPhoneNumber(newPhoneNumber);
                System.out.println("Patron details updated successfully.");
                return;
            }
        }
        System.out.println("Patron not found.");
    }
//create public void delete and display for patron
    public void deletePatron(String name) {
        patrons.removeIf(patron -> patron.getName().equals(name));
        System.out.println("Patron removed from the library.");
    }

    public void displayPatrons() {
        System.out.println("Patron List:");
        for (Patron patron : patrons) {
            patron.display();
        }
    }

}
