package polsl.jium.kszerlag.model.evaluator;

import java.util.ArrayDeque;
import java.util.Deque;
import polsl.jium.kszerlag.model.arithmetic.ArithmeticOperation;
import polsl.jium.kszerlag.model.arithmetic.Calculable;

/**
 * 
 *
 * @author szerlag
 */
public class PolishNotationExpressionEvaluator<T extends Calculable> implements EvaluationExpressionStrategy<T> {
    
    @Override
    public T eval(String expression) throws EvaluationExpressionException {
        String postfixExp = toPostifix(expression);
        Deque<T> stack = new ArrayDeque<>();
        ArithmeticOperation arithmeticOperation;
        for (int i = 0; i < postfixExp.length(); i++) {
            char sym = postfixExp.charAt(i);
            if (EvaluationExpressionUtil.isNumber(sym)) {
                stack.push(sym);
            }
            if (EvaluationExpressionUtil.isAritchmeticOperator(sym)) {
                T first = stack.pop();
                T second = stack.pop();
                
            }
        }
    }
    
    public String toPostifix(String infixExpression) {
        infixExpression = infixExpression.replace(" ", "");
        Deque<Character> out = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < infixExpression.length(); i++) {
            char sym = infixExpression.charAt(i);
            if (EvaluationExpressionUtil.isNumber(sym)) {
                out.addLast(sym);
            }
            if (EvaluationExpressionUtil.isAritchmeticOperator(sym)) {
                while (priority(sym) <= priority(stack.peek())) {
                    out.addLast(stack.pop());
                }
                stack.push(sym);
            }
            if (sym == '(') {
                stack.push(sym);
            }
            if (sym == ')') {
                while (stack.peek() != '(') {
                    out.addLast(stack.pop());
                }
                stack.pop();
            }
            if (infixExpression.length() == i + 1) {
                while(stack.size() > 0) {
                    out.addLast(stack.pop());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        out.forEach(c -> sb.append(c));
        return sb.toString();
    }
    
    /**
     * Determining operator priority.
     * 
     * 
     * @version 1.0 <b>Note:</b> version 1.0 doesn't support <b>unary</b> operators.
     * @param op - arithmetical operator
     * @return 
     */
    private int priority(Character op) {
        if (op == null) {
            return -1;
        }
        if (op == '+' || op == '-') {
            return 1; 
        }
        if (op == '*' || op == ':') {
            return 2;
        }
        return -1;
    }
}
