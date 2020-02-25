package com.company;

public class LiteralExpression implements Expression {

    String result;

    public LiteralExpression(String result) {
        this.result = result;
    }

    @Override
    public String eval() {
        return this.result;
    }
}
