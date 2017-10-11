package expressions;

import expressions.exceptions.ArithmeticException;

public class Min extends BinaryExpression {

    public Min(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    public double evaluate() throws ArithmeticException {
        return first.evaluate() > second.evaluate() ? second.evaluate() : first.evaluate();
    }
}
