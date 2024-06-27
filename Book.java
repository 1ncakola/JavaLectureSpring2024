public class Book extends LibraryItem {
   //Create public enum for Booktype 
    public enum BookType{
        PRINTED, ELECTRONIC, AUDIO
    }
    private BookType type;

    public Book(String id, String title, Author author, String ISBN, String publisher, int numCopies, BookType type) {
        super(id, title, author, ISBN, publisher, numCopies);
        this.type = type;
    }
    //Getter and Setter
    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    


   //Create override for borrow and return items
    
    @Override
    public boolean borrowItems(int numCopies) {
        return true;
    }

   @Override
    public void returnItems(int numCopies){
        setNumCopies(getNumCopies() + numCopies);


    //Create override for display and Publisher
        }
    @Override
    public void display() {
        System.out.println("Book [id=" + id + ", title=" + title + ", author=" + author.getName() + ", ISBN=" + ISBN + ", publisher=" + publisher + ", numberOfCopies=" + numCopies + ", type=" + type + "]");
    }

    @Override
    protected void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
