package github.fredsonchaves07.mathj.arithmetic;

import github.fredsonchaves07.mathj.core.Number;

import java.util.List;

public interface Arithmetic {

    Number sum(Number number);

    Number sumNumbers(List<Number> numbers);

    Number sub(Number number);

    Number dub(List<Number> numbers);

    Number mult(Number number);

    Number mult(List<Number> numbers);

    Number div(Number number);

    Number div(List<Number> numbers);

    boolean isDecimal();
}
