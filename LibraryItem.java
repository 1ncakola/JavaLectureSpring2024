//Create public Abstract class for LibraryItem

public abstract class LibraryItem {
    protected String id;
    protected String title;
    protected Author author;
    protected String ISBN;
    protected String publisher;
    protected int numCopies;

    public LibraryItem(String id, String title, Author author, String ISBN, String publisher, int numCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numCopies = numCopies;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    // Abstract method to be implemented by subclasses
    public abstract void display();

    public abstract boolean borrowItems(int numCopies);
 
    public abstract void returnItems(int numCopies);
    
    protected abstract void setPublisher(String publisher); 

}