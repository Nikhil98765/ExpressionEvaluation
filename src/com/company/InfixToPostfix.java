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
                case "-":
                    return 1;
                case "*":
                case "/":
                    return 2;
                case "^":
                    return 3;
                case ")":
                case "(":
                    return 4;
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
                System.out.println("Got an operand");
                postfixTokens.add(token);
            } else if (token instanceof Paranthesis) {
                if (((Paranthesis) token).data == '(') {
                    System.out.println("paranthesis");
                    stack.push(token);
                } else if (((Paranthesis) token).data == ')') {
//
                    System.out.println("inside paranthesis");

                    if (stack.isEmpty()) {
                        System.out.println("Checkkkk");
                    } else {
                        while (true) {
                            if (stack.peek() instanceof Paranthesis) {
                                if (!stack.isEmpty()&&((Paranthesis) stack.peek()).data != '(') {

                                    stack.pop();
                                    break;
                                }
                                System.out.println("inside");
                                break;

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
//                    while (!stack.isEmpty() && Prec(token) <= Prec(stack.peek())) {
//                        if (stack.peek() instanceof Paranthesis) {
//                            if (((Paranthesis) stack.peek()).data == '(')
//                                throw new ExpressionEvaluationException("invalid expression");
//                        }
//                        System.out.println("operator checked");
//                        postfixTokens.add(stack.pop());
//
//                    }
//                    stack.push(token);
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


