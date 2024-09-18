package github.fredsonchaves07.mathj.arithmetic;

import github.fredsonchaves07.mathj.core.Number;

public interface Arithmetic {

    Number sum(Number number);

    Number sub(Number number);

    Number mult(Number number);

    Number div(Number number);

    boolean isDecimal();

    boolean isInt();

    boolean isZero();
}
