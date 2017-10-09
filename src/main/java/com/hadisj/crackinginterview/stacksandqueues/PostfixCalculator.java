package com.hadisj.crackinginterview.stacksandqueues;

import java.util.*;
import java.util.Stack;

/**
 * Created by admin on 7/6/17.
 */
public class PostfixCalculator {

    private java.util.Stack<Integer> operands = new Stack<>();

    int calculate(String postfixInput) {
        StringTokenizer st = new StringTokenizer(postfixInput, " ");
        while (st.hasMoreTokens()) {
            String value = st.nextToken();
            if (isOperator(value)) {
                int operandB = operands.pop();
                int operandA = operands.pop();
                int result = 0;
                switch (value) {
                    case "+":
                        result = operandA + operandB;
                        break;
                    case "-":
                        result = operandA - operandB;
                        break;
                    case "*":
                        result = operandA * operandB;
                        break;
                    case "/":
                        result = operandA / operandB;
                        break;
                    default:
                        result = 0;
                        break;
                }
                operands.push(result);
            } else {
                operands.push(Integer.parseInt(value));
            }
        }
        return operands.pop();
    }

    private boolean isOperator(String value) {
        if (value.matches("[+|-|*|/]"))
            return true;
        return false;
    }

    public static void main(String[] args) {

        PostfixCalculator prog = new PostfixCalculator();
        String input = "6 2 / 5 +";
        int result = prog.calculate(input);
        System.out.println("Result for " +input+ " is "+ result);

        input = "6 2 / 5 + 10 *";
        result = prog.calculate(input);
        System.out.println("Result for " +input+ " is "+ result);
    }
}
