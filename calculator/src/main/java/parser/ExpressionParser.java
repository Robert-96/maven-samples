package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import expressions.*;
import parser.exceptions.SyntaxErrorException;

public class ExpressionParser {

    private ExpressionsList expressions;

    public ExpressionParser() {
        expressions = new ExpressionsList();

        expressions.registerExpression("+", Addition.class);
        expressions.registerExpression("-", Subtraction.class);

        expressions.registerExpression("*", Multiplication.class);
        expressions.registerExpression("/", Division.class);
    }

    Expression parserExpression(String expression) throws SyntaxErrorException {

        for (String sign : expressions.getSigns()) {

            Pattern expressionPattern =  Pattern.compile(String.format("(\\d+)\\s*\\%s\\s*(\\d+)\\s*", sign));
            Matcher matcher = expressionPattern.matcher(expression);

            if (matcher.matches()) {
                try {
                    Expression first = new Constant(Integer.valueOf(matcher.group(1)));
                    Expression second = new Constant(Integer.valueOf(matcher.group(2)));

                    return expressions.getExpression(sign).getConstructor(Expression.class, Expression.class).newInstance(first, second);
                } catch (ReflectiveOperationException exception) {
                    throw new SyntaxErrorException("Error: Syntax Error.");
                }
            }
        }

        throw new SyntaxErrorException("Error: No operation found.");
    }
}
