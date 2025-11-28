package Chapter_02_Advanced_OOP;
class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;
 
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void checkOut() {
        isCheckedOut = true;
    }
 
    public void returnBook() {
        isCheckedOut = false;
    }
 
    public boolean isAvailable() {
        return !isCheckedOut;
    }
 
    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Available: " + isAvailable());
    }
}
 
// LibraryCatalog.java
public class LibraryCatalog {
    public static void main(String[] args) {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book book2 = new Book("1984", "George Orwell");
 
        System.out.println("Initial Library Status:");
        book1.display();
        book2.display();
        System.out.println("-------------------------");
 
        System.out.println("Checking out 'The Hobbit'...");
        book1.checkOut();
        
        System.out.println("\nLibrary Status after checkout:");
        book1.display();
        book2.display();
        System.out.println("-------------------------");
        
        System.out.println("Returning 'The Hobbit'...");
        book1.returnBook();
 
        System.out.println("\nFinal Library Status:");
        book1.display();
        book2.display();
    }
}
