package com.company;

import java.util.ArrayList;

public class ExpressionController {

    ArrayList<Object> tokens;

    public ExpressionController(ArrayList<Object> tokens) {
        this.tokens = tokens;
    }

    public void init(){
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation(tokens);
        System.out.println(expressionEvaluation.evaluate());
    }

}
