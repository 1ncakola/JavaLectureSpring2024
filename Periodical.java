//Create public class for periodical

public class Periodical extends LibraryItem {
//Create enum for periocicaltype
    public enum PeriodicalType {
        PRINTED, ELECTRONIC
    }

    private PeriodicalType type; // printed, electronic
    private String publicationFrequency;

    public Periodical(String id, String title, Author author, String ISBN, String publisher, int numCopies, PeriodicalType type) {
        super(id, title, author, ISBN, publisher, numCopies);
        this.type = type;
    }

    public PeriodicalType getType() {
        return type;
    }

    public void setType(PeriodicalType type) {
        this.type = type;
    }

    
    public String getPublicationFrequency() {
        return publicationFrequency;
    }
    public void setPublicationFrequency(String publicationFrequency) {
       this.publicationFrequency = publicationFrequency;
    }
 
    //defines methods to borrow and return library items
@Override  
public boolean borrowItems(int numCopies) {
    return true;
}
 
@Override  
public void returnItems(int numCopies) {
}
//Create protected void for publisher
@Override
protected void setPublisher(String publisher){
    this.publisher = publisher;
}
//create public void for display
    @Override
    public void display() {
        System.out.println("Periodical [id=" + id + ", title=" + title + ", author=" + author.getName() + ", ISBN=" + ISBN + ", publisher=" + publisher + ", numCopies=" + numCopies + ", type=" + type + "]");
    }
    
}
