package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InfixToPostfix {

    ArrayList<Object> tokens;
    private Object Token;
    Queue<Object> queue = new LinkedList<>();


    static int Prec(Object ch) {
        if (ch instanceof Operator) {
            switch (((Operator) ch).data) {
                case "+":
                    return 2;
                case "-":
                    return 1;
                case "*":
                    return 3;
                case "/":
                    return 4;
                case "^":
                    return 5;

            }
        }
        return -1;
    }

    public InfixToPostfix(ArrayList<Object> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<Object> convertInfixToPostfix() {

        ArrayList<Object> postfixTokens = new ArrayList<>();

        Stack<Object> stack = new Stack<>();


        for (Object token : this.tokens) {
            if (token instanceof Operand) {

                postfixTokens.add(token);
            } else if (token instanceof Paranthesis) {
                if (((Paranthesis) token).data == '(') {

                    stack.push(token);
                } else if (((Paranthesis) token).data == ')') {

                    if (stack.isEmpty()) {
                        throw new ExpressionValidationException("not valid expression");
                    } else {
                        while (true) {
                            if (stack.peek() instanceof Paranthesis) {
                                if (!stack.isEmpty() && ((Paranthesis) stack.peek()).data != '(') {

                                    stack.pop();

                                } else {
                                    stack.pop();

                                    break;

                                }
                            }
                            else{
                                postfixTokens.add(stack.pop());
                            }

                        }
                        if (!stack.empty()) {
                            if (stack.peek() instanceof Paranthesis) {
                                if (((Paranthesis) stack.peek()).data != '(') {
                                    stack.pop();

                                }
                            }
                        }
                    }
                }
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(token) <= Prec(stack.peek())) {
                    if (stack.peek() instanceof Paranthesis)
                        if (((Paranthesis) stack.peek()).data == '(')
                            System.out.println("error");
                    postfixTokens.add(stack.pop());
                }
                stack.push(token);
            }
        }


        while (!stack.isEmpty()) {
            if (stack.peek() instanceof Paranthesis) {
                if (((Paranthesis) stack.peek()).data == ')')
                    throw new ExpressionValidationException("Invalid expression");
            }

            postfixTokens.add(stack.pop());
            postfixTokens.removeIf(op -> op instanceof Paranthesis);
        }


        return postfixTokens;
    }
}


