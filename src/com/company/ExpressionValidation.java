package com.company;

import java.util.ArrayList;

public class ExpressionValidation {

    ArrayList<Object> tokens  = new ArrayList<>();

    public ExpressionValidation(ArrayList<Object> tokens) {
        this.tokens = tokens;
    }

    public void validation(){

        if(tokens.get(tokens.size()-1) instanceof BinaryOperator){
            throw new ExpressionValidationException("not a valid expression");
        }
        int count =0;



    }

}
