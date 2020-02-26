package Expressions;

import Operands.Operand;
import Operators.UnaryOperator;

public class UnaryExpression implements Expression {


    UnaryOperator un;
    Operand op;

    public UnaryExpression(UnaryOperator un, Operand op) {
        this.un = un;
        this.op = op;
    }

    @Override
    public Double eval() {
        return 0.0;
    }
}
