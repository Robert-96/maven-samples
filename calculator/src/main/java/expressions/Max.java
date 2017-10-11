package expressions;

import expressions.exceptions.ArithmeticException;

public class Max extends BinaryExpression {

    public Max(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    public double evaluate() throws ArithmeticException {
        return first.evaluate() > second.evaluate() ? first.evaluate() : second.evaluate();
    }
}