package expressions;

import expressions.exceptions.ArithmeticException;

public class Division extends BinaryExpression {

    public Division(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    public double evaluate() throws ArithmeticException {
        if (second.evaluate() == 0) {
            throw new ArithmeticException("Error: Cannot divide by zero.");
        }

        return first.evaluate() / second.evaluate();
    }
}
