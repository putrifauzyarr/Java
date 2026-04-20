public class Math {
    double number1;
    double number2; 
    double number3;
    
    public Math(double number1, double number2, double number3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public double add() {
        return number1 + number2 + number3;  // return itu keyword getter
    }

    public double divide() {
        return (number1 + number2) / number3;
    }

    public double multiple() {
        return number1 * number2 * number3;
    }   
}