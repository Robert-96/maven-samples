package expressions;

import expressions.exceptions.ArithmeticException;

public class Subtraction extends BinaryExpression {

    public Subtraction(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    public double evaluate() throws ArithmeticException {
        return first.evaluate() - second.evaluate();
    }
}
