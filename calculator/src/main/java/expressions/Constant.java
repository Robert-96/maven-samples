package expressions;

import expressions.exceptions.ArithmeticException;

public class Constant implements Expression {

    protected double term;

    public Constant(double term) {
        this.term = term;
    }

    @Override
    public double evaluate() throws ArithmeticException {
        return term;
    }
}
