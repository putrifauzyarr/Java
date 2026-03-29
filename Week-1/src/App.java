import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();

        System.out.print("Enter the third number: ");
        double num3 = input.nextDouble();

        Math math = new Math(num1, num2, num3);

        System.out.println("Add Result: " + math.add());
        System.out.println("Divide Result: " + math.divide());
        System.out.println("Multiple Result: " + math.multiple());

        input.close();
    }
}