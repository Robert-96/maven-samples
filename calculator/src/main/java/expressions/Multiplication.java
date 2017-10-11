package expressions;

import expressions.exceptions.ArithmeticException;

public class Multiplication extends BinaryExpression {

    public Multiplication(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    public double evaluate() throws ArithmeticException{
        return first.evaluate() * second.evaluate();
    }
}
