package github.fredsonchaves.mathj.arithmetic;

import github.fredsonchaves07.mathj.core.Number;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationFundamentalsTest {

    @Test
    public void shouldBeSumIntNumbers() {
        Number number1 = Number.of(10);
        Number number2 = Number.of(65);
        Number result = Number.of(75);
        assertEquals(result, number1.sum(number2));
    }

    @Test
    public void shouldBeSumDecimalNumbers() {
        Number number1 = Number.of(910.658);
        Number number2 = Number.of(65.69);
        Number result = Number.of(976.348);
        assertEquals(result, number1.sum(number2));
    }

    @Test
    public void shouldBeSumListNumbers() {
        List<Number> numbers = List.of(
                Number.of(10), Number.of(100), Number.of(5.6), Number.of(6.78));
        Number result = Number.of(122.38);
        assertEquals(result, Number.sum(numbers));
    }
}
