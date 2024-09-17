package github.fredsonchaves.mathj.arithmetic;

import github.fredsonchaves07.mathj.core.Number;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NumberTest {

    @Test
    public void shouldBeCreateANumber() {
        Number number1 = Number.of(1);
        Number number2 = Number.of(2.0);
        assertNotNull(number1);
        assertNotNull(number2);
        assertEquals(number1.asInt(), 1);
        assertEquals(number2.asDecimal(), 2.0);
    }
}
