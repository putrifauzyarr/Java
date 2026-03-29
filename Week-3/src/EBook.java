public class EBook extends Book {
    double fileSize; 

    public EBook(String title, String author, int year, double fileSize) {
        super(title, author, year);
        this.fileSize = fileSize;
    }
    
    public double downloadTime(double speed) {
        return fileSize / speed; 
    }

    public void displayEBook(double speed) {
        displayInfo();
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Download Time at " + speed + " MB/s: " + downloadTime(speed) + " seconds");
        System.out.println();
    }
}
