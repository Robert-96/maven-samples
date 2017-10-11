package expressions;

import expressions.exceptions.ArithmeticException;

public abstract class UnaryExpression implements Expression {

    protected Expression term;

    public UnaryExpression(Expression term) {
        this.term = term;
    }

    @Override
    abstract public double evaluate() throws ArithmeticException;
}
