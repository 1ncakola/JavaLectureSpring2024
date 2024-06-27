//Create public class for adult patron 

public class adultpatron extends Patron {
    public adultpatron(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }

    //Create Override for display
    @Override
    public void display() {
        System.out.println("Adult Patron: " + getName() + ", Address: " + getAddress() + ", Phone: " + getPhoneNumber());
    }
}
