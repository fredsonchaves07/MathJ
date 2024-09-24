package github.fredsonchaves.mathj.arithmetic;

import github.fredsonchaves07.mathj.core.Number;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleDividersTest {

    @Test
    public void shouldBeMultipleNumber() {
        String expectedNumbers = "[7, 14, 21, 28, 35, 42, 49, 56, 63, 70]";
        Number number = Number.of(7);
        List<Number> multiplesNumber = number.multiples();
        assertFalse(multiplesNumber.isEmpty());
        assertEquals(10, multiplesNumber.size());
        assertEquals(expectedNumbers, multiplesNumber.toString());
    }

    @Test
    public void shouldBeMultipleNumberOfQuantity() {
        String expectedNumbers = "[7, 14, 21, " +
                "28, 35, 42, 49, " +
                "56, 63, 70, 77, 84," +
                " 91, 98, 105, 112," +
                " 119, 126, 133, 140," +
                " 147, 154, 161, 168, " +
                "175, 182, 189, 196, 203, 210]";
        Number number = Number.of(7);
        List<Number> multiplesNumber = number.multiples(30);
        assertFalse(multiplesNumber.isEmpty());
        assertEquals(30, multiplesNumber.size());
        assertEquals(expectedNumbers, multiplesNumber.toString());
    }

    @Test
    public void shouldBeDividersNumber() {
        String expectedNumbers = "[1, 2, 3, 4, 6, 9, 12, 18, 36]";
        Number number = Number.of(36);
        List<Number> multiplesNumber = number.dividers();
        assertFalse(multiplesNumber.isEmpty());
        assertEquals(9, multiplesNumber.size());
        assertEquals(expectedNumbers, multiplesNumber.toString());
    }

    @Test
    public void shouldBeCountDividersOfNumber() {
        Number number = Number.of(36);
        int sizeDividers = number.sizeOfDividers();
        assertEquals(9, sizeDividers);
    }
}
