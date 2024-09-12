package github.fredsonchaves07.mathj.arithmetic;

public class Arithmetic {

    public static int sum(int ... values) {
        int result = 0;
        for (int value : values) result += value;
        return result;
    }

    public static double sum(double ... values) {
        double result = 0.0;
        for (double value : values) result += value;
        return result;
    }
}
