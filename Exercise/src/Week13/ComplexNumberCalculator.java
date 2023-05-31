package Week13;

public interface ComplexNumberCalculator {
    public ComplexNumber add(ComplexNumber c1, ComplexNumber c2);
    public ComplexNumber sub(ComplexNumber c1, ComplexNumber c2);
    public ComplexNumber mul(ComplexNumber c1, ComplexNumber c2);
    default void printResult(ComplexNumber c){
        System.out.printf("Real: %s, Imaginary: %s", c.real.toString(), c.imaginary.toString());
    }
}
