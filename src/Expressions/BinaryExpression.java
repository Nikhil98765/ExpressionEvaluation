package Expressions;

import Operators.BinaryOperator;
import Operands.Operand;

public class BinaryExpression implements Expression {

    BinaryOperator bop;
    Operand op1;
    Operand op2;

    public BinaryExpression(BinaryOperator bop, Operand op1, Operand op2) {
        this.bop = bop;
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public Double eval() {
        return 0.0;
    }
}
