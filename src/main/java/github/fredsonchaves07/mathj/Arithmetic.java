package github.fredsonchaves07.mathj;

import java.util.List;

public class Arithmetic {

    protected static int sum(int ... values) {
        int result = 0;
        for (int value : values) result += value;
        return result;
    }

    protected static double sum(double ... values) {
        double result = 0.0;
        for (double value : values) result += value;
        return result;
    }

    protected static int sub(int ... values) {
        int result = 0;
        for (int value : values) {
            if (result == 0 && value != 0) {
                result = value;
                continue;
            }
            result -= value;
        }
        return result;
    }

    protected static double sub(double ... values) {
        double result = 0;
        for (double value : values) {
            if (result == 0 && value != 0) {
                result = value;
                continue;
            }
            result -= value;
        }
        return result;
    }

    protected static int mult(int ... values) {
        int result = 1;
        for (int value : values) result *= value;
        return result;
    }

    protected static double mult(double ... values) {
        double result = 1;
        for (double value : values) result *= value;
        return result;
    }

    protected static int div(int ... values) {
        if (List.of(values).contains(0))
            throw new RuntimeException("Cannot divide a number by 0");
        int result = 0;
        for (int value : values) {
            if (result == 0 && value != 0) {
                result = value;
                continue;
            }
            result /= value;
        }
        return result;
    }

    protected static double div(double ... values) {
        if (List.of(values).contains(0))
            throw new RuntimeException("Cannot divide a number by 0");
        double result = 0;
        for (double value : values) {
            if (result == 0 && value != 0) {
                result = value;
                continue;
            }
            result /= value;
        }
        return result;
    }
}
