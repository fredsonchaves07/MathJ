package github.fredsonchaves.mathj.arithmetic;

import github.fredsonchaves07.mathj.core.Number;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void shouldBeSubtractIntNumbers() {
        Number number1 = Number.of(10);
        Number number2 = Number.of(65);
        Number result = Number.of(-55);
        assertEquals(result, number1.sub(number2));
    }

    @Test
    public void shouldBeSubtractDecimalNumbers() {
        Number number1 = Number.of(910.658);
        Number number2 = Number.of(65.69);
        Number result = Number.of(844.9680000000001);
        assertEquals(result, number1.sub(number2));
    }

    @Test
    public void shouldBeSubtractListNumbers() {
        List<Number> numbers = List.of(
                Number.of(10), Number.of(100), Number.of(5.6), Number.of(6.78));
        Number result = Number.of(-102.38);
        assertEquals(result, Number.sub(numbers));
    }

    @Test
    public void shouldBeMultiplyIntNumbers() {
        Number number1 = Number.of(10);
        Number number2 = Number.of(65);
        Number result = Number.of(650);
        assertEquals(result, number1.mult(number2));
    }

    @Test
    public void shouldBeMultiplyDecimalNumbers() {
        Number number1 = Number.of(910.658);
        Number number2 = Number.of(65.69);
        Number result = Number.of(59821.124019999996);
        assertEquals(result, number1.mult(number2));
    }

    @Test
    public void shouldBeMultiplyListNumbers() {
        List<Number> numbers = List.of(
                Number.of(10), Number.of(100), Number.of(5.6), Number.of(6.78));
        Number result = Number.of(37968);
        assertEquals(result, Number.mult(numbers));
    }

    @Test
    public void shouldBeDivIntNumbers() {
        Number number1 = Number.of(10);
        Number number2 = Number.of(65);
        Number result = Number.of(0.15384615384615385);
        assertEquals(result, number1.div(number2));
    }

    @Test
    public void shouldBeDivDecimalNumbers() {
        Number number1 = Number.of(910.658);
        Number number2 = Number.of(65.69);
        Number result = Number.of(13.862962399147511);
        assertEquals(result, number1.div(number2));
    }

    @Test
    public void shouldBeDivListNumbers() {
        List<Number> numbers = List.of(
                Number.of(10), Number.of(100), Number.of(5.6), Number.of(6.78));
        Number result = Number.of(0.002633797);
        assertEquals(result, Number.div(numbers));
    }

    @Test
    public void shouldNotBeDivByZero() {
        Number number1 = Number.of(910.658);
        Number number2 = Number.of(0);
        assertThrows(
                RuntimeException.class, () -> number1.div(number2));
    }
}
