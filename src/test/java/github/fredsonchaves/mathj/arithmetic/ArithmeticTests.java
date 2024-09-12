package github.fredsonchaves.mathj.arithmetic;

import github.fredsonchaves07.mathj.MathJ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticTests {

    @Test
    public void shouldBeSumIntNumbers() {
        int value1 = 65014;
        int value2 = 12023;
        int result = value1 + value2;
        assertEquals(result, MathJ.sum(value1, value2));
    }

    @Test
    public void shouldBeSumDoubleNumbers() {
        double value1 = 6014.6;
        double value2 = 121.8641;
        double result = value1 + value2;
        assertEquals(result, MathJ.sum(value1, value2));
    }
}
