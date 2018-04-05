package complexnumbers;

public class ComplexNumber {
    private double real;
    private double image;
    private java.text.DecimalFormat decimalFormat;

    public ComplexNumber(double re, double im){
        this.real = re;
        this.image = im;
        decimalFormat = new java.text.DecimalFormat("##0.00");
    }

    public ComplexNumber add (ComplexNumber rValue){
        double realSum = real + rValue.real;
        double imageSum = image + rValue.image;
        ComplexNumber result = new ComplexNumber(realSum, imageSum);
        String formatReal = decimalFormat.format(result.real);
        String formatImage = decimalFormat.format(result.image);
        System.out.println("Sum: " + formatReal + "+" + formatImage + "i");
        return result;
    }

    public ComplexNumber ded (ComplexNumber rValue){
        double realSum = real - rValue.real;
        double imageSum = image - rValue.image;
        ComplexNumber result = new ComplexNumber(realSum, imageSum);
        String formatReal = decimalFormat.format(result.real);
        String formatImage = decimalFormat.format(result.image);
        System.out.println("Deduction: " + formatReal + "+" + formatImage + "i");
        return result;
    }

    public ComplexNumber mult (ComplexNumber rValue){
        double realSum = real * rValue.real - image * rValue.image;
        double imageSum = real * rValue.image + image * rValue.real;
        ComplexNumber result = new ComplexNumber(realSum, imageSum);
        String formatReal = decimalFormat.format(result.real);
        String formatImage = decimalFormat.format(result.image);
        System.out.println("Multiplication: " + formatReal + "+" + formatImage + "i");
        return result;

    }

    public ComplexNumber div (ComplexNumber rValue){
        if ((rValue.real) == 0 || (rValue.image) == 0){
            System.out.print("0 div!");
        }
        double realSum = (real * rValue.real + image * rValue.image)/(rValue.real*rValue.real + rValue.image*rValue.image);
        double imageSum = (image*rValue.real - real*rValue.image)/(rValue.real*rValue.real + rValue.image*rValue.image);
        ComplexNumber result = new ComplexNumber(realSum, imageSum);
        String formatReal = decimalFormat.format(result.real);
        String formatImage = decimalFormat.format(result.image);
        System.out.println("Division: " + formatReal + "+" + formatImage + "i");
        return result;

    }

    private double getModule(int n){
        double module = Math.sqrt(real*real+image*image);
        double result = Math.pow(module, (1/(double)n));
        return result;
    }

    private double getArg(){
        double result = Math.atan(image/real);
        if (real < 0 && image > 0)
            result = Math.PI+result;
        if (real < 0 && image < 0)
            result = -Math.PI+result;
//        System.out.println(result);
        return result;
    }

    public java.util.ArrayList root (int n){
        java.util.ArrayList numbers = new java.util.ArrayList();
        System.out.println("Roots:");
        for (int x=0; x<n; x++) {
            numbers.add(new ComplexNumber(getModule(n)* Math.cos((getArg() + 2 * Math.PI * x) / 2), getModule(n)*Math.sin((getArg() + 2 * Math.PI * x) / 2)));
            String formatReal = decimalFormat.format(Math.cos((getArg() + 2 * Math.PI * x) / 2));
            String formatImage = decimalFormat.format(Math.sin((getArg() + 2 * Math.PI * x) / 2));
            System.out.println(x+1 + ". " + formatReal + "+" + formatImage + "i");
        }
        return numbers;
    }
}
