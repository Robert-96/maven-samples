package expressions;

import expressions.exceptions.ArithmeticException;

public class Sqrt extends UnaryExpression {

    public Sqrt(Expression term) {
        super(term);
    }

    @Override
    public double evaluate() throws ArithmeticException {
        return Math.sqrt(term.evaluate());
    }
}
