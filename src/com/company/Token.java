package com.company;

import Exceptions.TokenException;
import Operands.Operand;
import Operators.BinaryOperator;
import Operators.FunctionOperator;
import Operators.Operator;
import Operators.UnaryOperator;

import java.util.ArrayList;

public class Token {

    String inputExpression;
    ArrayList<Object> tokens;

    public Token(String inputExpression) {
        this.inputExpression = inputExpression;
        this.tokens = new ArrayList<Object>();
    }


    public ArrayList<Object> getTokens() {
        return tokens;
    }

    public ArrayList<Object> Lexer(){
        UnaryOperator uop = new UnaryOperator();

        BinaryOperator bop = new BinaryOperator();

        FunctionOperator fop = new FunctionOperator();

        char[] characters = inputExpression.toCharArray();

        String number = "";
        String function;
        int count = 0;
        String negativeNumber = "";

        for(int i = 0; i< characters.length; i++){

            if((characters[i] == '-') && ((Character.isDigit(characters[i+1])))){
                negativeNumber += characters[i];
                for(int j = i+1; j<characters.length;j++){
                    if(Character.isDigit(characters[j])){
                        negativeNumber += characters[j];
                        i++;
                    }else{
                        break;
                    }
                }
                tokens.add(new Operand(negativeNumber));
                negativeNumber = "";

            }else if((characters[i] == '.')){
                if(count >= 2){
                    throw new TokenException("not valid floating number");
                }else {
                    count += 1;
                    number += characters[i];
                }
            }else if((Character.isDigit(characters[i]))){
                number += characters[i];
                if((i+1<inputExpression.length()) && ((Character.isDigit(characters[i+1]))||(characters[i+1] == '.')) ){
                    continue;
                }else{
                    if(number.charAt(number.length()-1) == '.'){
                        throw new TokenException("not a valid operand");
                    }else{
                    tokens.add(new Operand(number));
                    number = "";
                    }
                }

            }
            else if(bop.isBinaryOperator(characters[i])){
                tokens.add(new BinaryOperator(Character.toString(characters[i])));

            }else if (Character.isLetter(characters[i])) {

                function = "";

                while (i < characters.length && Character.isLetter(characters[i])) {
                    function += characters[i];

                    i++;
                }

                if(fop.isFunctionOperator(function)) {
                    tokens.add(new FunctionOperator(function));

                }else{
                    throw new TokenException("not valid token");
                }
                i--;
            }else if(characters[i] == '(' || characters[i] == ')'){
                tokens.add(new Paranthesis(characters[i]));
            }
            else{
                throw new TokenException("token not found");
            }
        }



        return tokens;

    }
}
