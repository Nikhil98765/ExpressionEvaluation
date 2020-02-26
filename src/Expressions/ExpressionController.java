package Expressions;

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
        for(Object ob: postfixTokens){
            System.out.println(ob);
        }
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation(postfixTokens);
        System.out.println(expressionEvaluation.evaluate());
    }

}
