package com.company;

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

        char[] characters = inputExpression.toCharArray();

        String number = "";
        int count = 0;

        for(int i = 0; i< characters.length; i++){

            if((characters[i] == '.')){
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
