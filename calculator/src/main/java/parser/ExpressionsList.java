package parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import expressions.Expression;

public class ExpressionsList {

    private Map<String, Class<? extends  Expression>> expressions;

    public ExpressionsList() {
        expressions = new HashMap<>();
    }

    public void registerExpression(String sign, Class<? extends  Expression> expression) {
        expressions.put(sign, expression);
    }

    public boolean isRegistered(Class<? extends  Expression> expression) {
        return expressions.containsValue(expression);
    }

    public Class<? extends Expression> getExpression(String sign) {
        return expressions.get(sign);
    }

    public Set<String> getSigns() {
        return expressions.keySet();
    }
}
