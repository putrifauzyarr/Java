public class App {
    public static void main(String[] args) {

        PrintedBook pb1 = new PrintedBook("Psychology of Money", "Morgan Housel", 2020, 249);
        PrintedBook pb2 = new PrintedBook("Data Structures", "James Smith", 2022, 300);

        EBook eb1 = new EBook("Python Programming", "Jane Doe", 2021, 50);
        EBook eb2 = new EBook("Data Science", "Mike Brown", 2024, 60);
        
        pb1.displayPrintedBook();
        pb2.displayPrintedBook();

        eb1.displayEBook(10);
        eb2.displayEBook(15);
    }
}
