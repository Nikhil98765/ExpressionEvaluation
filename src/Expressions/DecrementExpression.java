package Expressions;

import Operands.Operand;
import Operators.UnaryOperator;

public class DecrementExpression extends UnaryExpression {


    public DecrementExpression(UnaryOperator un, Operand op) {

       super(un, op);

    }



    @Override
    public Double eval() {

        return null;
    }
}
