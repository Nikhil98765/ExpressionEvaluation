package com.company;

public class LiteralExpression implements Expression {

    String result;

    public LiteralExpression(String result) {
        this.result = result;
    }

    @Override
    public Double eval() {
        return 0.0;
    }
}
