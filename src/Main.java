public class Main {
    public static void main(String[] args) throws MyCheckException {
        //System.out.println(divide(1, 0));
        System.out.println(divideO(1,0));
    }

    public static double divide(double a, double b) throws MyCheckException {
        if (b == 0) {
            throw new MyCheckException("Divide by 0");
        }
        return a / b;
    }
    public static double divideO(double a, double b) {
        if (b == 0) {
            throw new MyUncheckException("Divide by 011");
        }
        return a / b;
    }
}