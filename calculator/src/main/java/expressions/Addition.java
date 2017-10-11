package expressions;

import expressions.exceptions.ArithmeticException;

public class Addition extends BinaryExpression {

    public Addition(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    public double evaluate() throws ArithmeticException {
        return first.evaluate() + second.evaluate();
    }
}