package Expressions;

import Operators.BinaryOperator;
import Operands.Operand;

public class MultiplicationExpression extends BinaryExpression {

    public MultiplicationExpression(BinaryOperator bop, Operand op1, Operand op2) {
        super(bop, op1, op2);
    }

    @Override
    public Double eval() {
        return (Double.parseDouble(op1.getData())*Double.parseDouble(op2.getData()));
    }

}
