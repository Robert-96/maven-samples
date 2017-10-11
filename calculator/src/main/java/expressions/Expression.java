package expressions;

import expressions.exceptions.ArithmeticException;

public interface Expression {
    double evaluate() throws ArithmeticException;
}