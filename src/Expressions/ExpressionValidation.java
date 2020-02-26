package Expressions;

import Operators.BinaryOperator;
import Exceptions.ExpressionValidationException;
import Operators.Operator;
import com.company.Paranthesis;

import java.util.ArrayList;

public class ExpressionValidation {

    ArrayList<Object> tokens  = new ArrayList<>();

    public ExpressionValidation(ArrayList<Object> tokens) {
        this.tokens = tokens;
    }

    public void validation(){

        int count = 0;
        if(tokens.get(tokens.size()-1) instanceof BinaryOperator){
            throw new ExpressionValidationException("not a valid expression");
        }
        for(Object ob: tokens){
            if(ob instanceof Paranthesis){
                if(((Paranthesis) ob).getData() == '('){
                    count++;
                }else{
                    count--;
                }
            }
            if(ob instanceof Operator){
                if((tokens.get(tokens.indexOf(ob)-1) instanceof Operator) && (tokens.get(tokens.indexOf(ob)+1) instanceof Operator)){
                    throw new ExpressionValidationException("not valid expression");
                }
            }
        }
        if(count != 0){
            throw new ExpressionValidationException("not balanced paranthesis");
        }


    }

}
