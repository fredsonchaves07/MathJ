package github.fredsonchaves07.mathj.core;

import github.fredsonchaves07.mathj.arithmetic.Arithmetic;

import java.util.*;

public final class Number implements Arithmetic, Comparable<Number>{

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

    @Override
    public List<Number> multiples() {
        return multiples(10);
    }

    @Override
    public List<Number> multiples(int quantity) {
        List<Number> numbers = new ArrayList<>(quantity);
        for (int i = 1; i <= quantity; i ++) numbers.add(this.mult(Number.of(i)));
        return numbers;
    }

    @Override
    public List<Number> dividers() {
        List<Number> numbers = new ArrayList<>();
        List<Number> factors = factors();
        numbers.add(Number.of(1));
       for (Number factor : factors) {
           numbers.addAll(dividers(numbers, factor));
       }
       Collections.sort(numbers);
       return numbers;
    }

    private List<Number> dividers(List<Number> numbers, Number factor) {
        List<Number> newNumbers = new ArrayList<>();
        for (Number number : numbers) {
            Number numberDivider = number.mult(factor);
            if (!numbers.contains(numberDivider)) newNumbers.add(numberDivider);
        }
        return newNumbers;
    }

    //TODO -> Put this method in the arithmetic interface
    private List<Number> factors() {
        List<Number> numbers = new ArrayList<>();
        int primeNumber = 2;
        int numberFactor = this.asInt();
        while (numberFactor != 1) {
            if (numberFactor % primeNumber == 0) {
                numberFactor = numberFactor / primeNumber;
                numbers.add(Number.of(primeNumber));
            }
            else primeNumber = nextPrimeNumber(primeNumber);
        }
        return numbers;
    }

    //TODO Put this method in the numbers interface
    private int nextPrimeNumber(int primeNumber) {
        int actualPrimeNumber = primeNumber + 1;
        int sizeOfDividers = 0;
        for (int i = 1; i <= primeNumber; i++) if (primeNumber % i == 0) sizeOfDividers ++;
        if (sizeOfDividers <= 2) return actualPrimeNumber;
        else return nextPrimeNumber(actualPrimeNumber);
    }

    @Override
    public int sizeOfDividers() {
        return dividers().size();
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(this.asInt(), o.asInt());
    }
}
