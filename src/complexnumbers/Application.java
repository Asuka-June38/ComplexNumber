package complexnumbers;

public class Application {
    public static void main (String[] args) {
        ComplexNumber firstNumber = new ComplexNumber(-67,-19);
        ComplexNumber secondNumber = new ComplexNumber(32,48);
        int n = 4;

        firstNumber.add(secondNumber);
        firstNumber.ded(secondNumber);
        firstNumber.mult(secondNumber);
        firstNumber.div(secondNumber);
        firstNumber.root(n);
    }
}
