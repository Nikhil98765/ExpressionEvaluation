package Expressions;

import Operands.Operand;
import Operators.FunctionOperator;

public class FunctionExpressions implements Expression {

    FunctionOperator fop;
    Operand op1;
    Operand op2;
    Double result;

    public FunctionExpressions(FunctionOperator fop, Operand op1) {
        this.fop = fop;
        this.op1 = op1;
        this.op2 = op2;
    }


    @Override
    public Double eval() {

        switch (fop.getData()){
            case "sin":
                result = Math.sin(Math.toRadians(Double.parseDouble(op1.getData())));
                break;
            case "cos":
                result = Math.cos(Math.toRadians(Double.parseDouble(op1.getData())));
                break;
            case "tan":
                result = Math.tan(Math.toRadians(Double.parseDouble(op1.getData())));
                break;

        }

        return this.result;
    }
}
