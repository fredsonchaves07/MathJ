package github.fredsonchaves07.mathj.core;

import github.fredsonchaves07.mathj.arithmetic.Arithmetic;

import java.util.List;
import java.util.Objects;

public final class Number implements Arithmetic {

    private final String value;


    private Number(Integer value) {
        this.value = String.valueOf(value);
    }

    private Number(Double value) {
        this.value = String.valueOf(value);
    }

    public int asInt() {
        return Integer.parseInt(value);
    }

    public double asDecimal() {
        return Double.parseDouble(value);
    }

    public static Number of(int value) {
        return new Number(value);
    }

    public static Number of(Number number) {
        if (number.isDecimal()) return new Number(number.asDecimal());
        return new Number(number.asInt());
    }

    public static Number of(double value) {
        if (String.valueOf(value).contains(".0")) return new Number((int) value);
        return new Number(value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(value, number.value);
    }

    @Override
    public Number sum(Number number) {
        if (isDecimal() || number.isDecimal()) return Number.of(asDecimal() + number.asDecimal());
        return Number.of(asInt() + number.asInt());
    }

    public static Number sum(List<Number> numbers) {
        if (numbers.isEmpty()) return Number.of(0);
        if (numbers.size() == 1) return Number.of(numbers.getFirst());
        return numbers.getFirst().sumNumbers(numbers.subList(1, numbers.size()));
    }

    private Number sumNumbers(List<Number> numbers) {
        Number result = Number.of(this);
        for (Number number : numbers) result = result.sum(number);
        return result;
    }

    @Override
    public Number sub(Number number) {
        if (isDecimal() || number.isDecimal()) return Number.of(asDecimal() - number.asDecimal());
        return Number.of(asInt() - number.asInt());
    }

    public static Number sub(List<Number> numbers) {
        if (numbers.isEmpty()) return Number.of(0);
        if (numbers.size() == 1) return Number.of(numbers.getFirst());
        return numbers.getFirst().subNumbers(numbers.subList(1, numbers.size()));
    }

    private Number subNumbers(List<Number> numbers) {
        Number result = Number.of(this);
        for (Number number : numbers) result = result.sub(number);
        return result;
    }

    @Override
    public Number mult(Number number) {
        if (isDecimal() || number.isDecimal()) return Number.of(asDecimal() * number.asDecimal());
        return Number.of(asInt() * number.asInt());
    }

    public static Number mult(List<Number> numbers) {
        if (numbers.isEmpty()) return Number.of(0);
        if (numbers.size() == 1) return Number.of(numbers.getFirst());
        return numbers.getFirst().multNumbers(numbers.subList(1, numbers.size()));
    }

    private Number multNumbers(List<Number> numbers) {
        Number result = Number.of(this);
        for (Number number : numbers) result = result.mult(number);
        return result;
    }

    @Override
    public Number div(Number number) {
        if (number.isZero()) throw new RuntimeException("It should not be possible to divide by zero");
        return Number.of(asDecimal() / number.asDecimal());
    }

    public static Number div(List<Number> numbers) {
        if (numbers.isEmpty()) return Number.of(0);
        if (numbers.size() == 1) return Number.of(numbers.getFirst());
        return numbers.getFirst().divNumbers(numbers.subList(1, numbers.size()));
    }

    private Number divNumbers(List<Number> numbers) {
        Number result = Number.of(this);
        for (Number number : numbers) {
            if (number.isZero()) throw new RuntimeException("It should not be possible to divide by zero");
            result = result.div(number);
        }
        return result;
    }

    @Override
    public boolean isDecimal() {
        return value.contains(".") && !value.contains(".0");
    }

    @Override
    public boolean isInt() {
        return !isDecimal();
    }

    @Override
    public boolean isZero() {
        return value.equals("0");
    }
}
