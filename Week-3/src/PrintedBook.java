public class PrintedBook extends Book {
    int pages;

    public PrintedBook(String title, String author, int year, int pages) {
        super(title, author, year);
        this.pages = pages;
    }
    
    public int readingTime() {
        return pages * 2; 
    }

    public void displayPrintedBook() {
        displayInfo();
        System.out.println("Pages: " + pages);
        System.out.println("Reading Time: " + readingTime() + " minutes");
        System.out.println();
    } 
}