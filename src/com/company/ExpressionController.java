package com.company;

import java.util.ArrayList;

public class ExpressionController {

    ArrayList<Object> tokens;

    public ExpressionController(ArrayList<Object> tokens) {
        this.tokens = tokens;
    }

    public void init(){

        ExpressionValidation expValid = new ExpressionValidation(tokens);
        expValid.validation();
        InfixToPostfix ip = new InfixToPostfix(tokens);
        ArrayList<Object> postfixTokens = ip.convertInfixToPostfix();
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation(postfixTokens);
        System.out.println(expressionEvaluation.evaluate());
    }

}
