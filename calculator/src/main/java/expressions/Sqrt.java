package expressions;

import expressions.exceptions.ArithmeticException;

public class Sqrt extends UnaryExpression {

    public Sqrt(Expression term) {
        super(term);
    }

    @Override
    public double evaluate() throws ArithmeticException {
        if (term.evaluate() < 0) {
            throw new ArithmeticException("Error: Cannot get square root of negative number.");
        }

        return Math.sqrt(term.evaluate());
    }
}
