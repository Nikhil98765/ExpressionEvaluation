package com.company;

public class UnaryExpression implements Expression {


    UnaryOperator un;
    Operand op;

    public UnaryExpression(UnaryOperator un, Operand op) {
        this.un = un;
        this.op = op;
    }

    @Override
    public String eval() {
        return null;
    }
}
