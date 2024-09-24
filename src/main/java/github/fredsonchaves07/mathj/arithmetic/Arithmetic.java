package github.fredsonchaves07.mathj.arithmetic;

import github.fredsonchaves07.mathj.core.Number;

import java.util.List;

public interface Arithmetic {

    Number sum(Number number);

    Number sub(Number number);

    Number mult(Number number);

    Number div(Number number);

    boolean isDecimal();

    boolean isInt();

    boolean isZero();

    List<Number> multiples();

    List<Number> multiples(int quantity);

    List<Number> dividers();

    int sizeOfDividers();
}
