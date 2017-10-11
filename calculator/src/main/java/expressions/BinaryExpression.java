package expressions;

import expressions.exceptions.ArithmeticException;

public abstract class BinaryExpression implements Expression {

    protected Expression first;
    protected Expression second;

    public BinaryExpression(Expression first, Expression second) {
        this.first = first;
        this.second = second;
    }

    abstract public double evaluate() throws ArithmeticException;
}
