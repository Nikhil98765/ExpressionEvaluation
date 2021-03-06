package Expressions;

import Operators.BinaryOperator;
import Operands.Operand;
import Operators.FunctionOperator;
import Operators.Operator;

import java.util.ArrayList;
import java.util.Stack;

public class ExpressionEvaluation {

    ArrayList<Object> tokens;
    Stack<Operand> operands = new Stack<>();
    String result;

    public ExpressionEvaluation(ArrayList<Object> tokens) {
        this.tokens = tokens;
    }

    public String evaluate(){



        for(Object ob :tokens){
            if (ob instanceof Operand){
                operands.push((Operand)ob);
            }else if(ob instanceof Operator){
                if((((Operator) ob).type) == "BinaryOperator"){
                    Operand op1 = operands.pop();
                    Operand op2 = operands.pop();
                    switch(((Operator) ob).data){
                        case "+":
                            AdditionExpression addExpr = new AdditionExpression((BinaryOperator)ob , op1, op2);
                            Double addResult = addExpr.eval();

                            operands.push(new Operand(addResult.toString()));

                            break;

                        case "-":
                            SubtractionExpression subExpr = new SubtractionExpression((BinaryOperator)ob , op1, op2);
                            Double subResult = subExpr.eval();
                            operands.push(new Operand(subResult.toString()));
                            break;
                        case "*":
                            MultiplicationExpression multiExpr = new MultiplicationExpression((BinaryOperator)ob, op1, op2);
                            Double mulResult = multiExpr.eval();
                            operands.push(new Operand(mulResult.toString()));
                            break;
                        case "/":
                            DivisionExpression divExpr = new DivisionExpression((BinaryOperator)ob, op1 , op2);
                            Double divResult = divExpr.eval();
                            operands.push(new Operand(divResult.toString()));
                            break;

                    }
                }else if(((Operator) ob).type == "FunctionOperator"){
                    Operand op3 = operands.pop();

                    switch (((Operator) ob).data){
                        case "sin":
                        case "tan":
                        case "cos":
                            FunctionExpressions sinExpr = new FunctionExpressions((FunctionOperator)ob,op3);
                            Double result = sinExpr.eval();
                            operands.push(new Operand(result.toString()));
                            break;
                    }
                }
            }
        }
        this.result = operands.pop().getData();
        return this.result;
    }
}
