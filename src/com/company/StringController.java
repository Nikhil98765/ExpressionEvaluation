package com.company;


import Expressions.ExpressionController;

import java.util.ArrayList;

public class StringController {

    String InputExpression;


    public StringController(String inputExpression) {
        this.InputExpression = inputExpression;
    }

    public void init() throws NoSuchFieldException, IllegalAccessException {

        Token t = new Token(this.InputExpression);
        ArrayList<Object> ts = t.Lexer();



       for(Object ob : ts){
           System.out.println(ob);
       }






        ExpressionController expressionController = new ExpressionController(ts);

        expressionController.init();


    }




//    ExpressionController ec = new ExpressionController(tokens);


}
