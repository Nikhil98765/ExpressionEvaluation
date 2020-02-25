package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UnaryOperator extends Operator {

    String[] unaryOperators = new String[] {"++", "--"};


    public UnaryOperator(String data) {
        type = "UnaryOperator";
        this.data = data;

    }

    public UnaryOperator(){

    }

    public String[] getUnaryOperators() {
        return unaryOperators;
    }

    public String getType(){
        return type;
    }

    public String getData() {
        return data;
    }

    public boolean isUnaryOperator(String token){
        for(int i = 0;i<unaryOperators.length; i++){
            if(token == unaryOperators[i]){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return ""+data +", " + type;
    }
}
