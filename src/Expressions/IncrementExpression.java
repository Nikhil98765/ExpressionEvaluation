package Expressions;

import Operands.Operand;
import Operators.UnaryOperator;

public class IncrementExpression extends UnaryExpression {


    public IncrementExpression(UnaryOperator un, Operand op) {

        super(un, op);

    }

    @Override
    public Double eval() {

        return null;
    }
}
