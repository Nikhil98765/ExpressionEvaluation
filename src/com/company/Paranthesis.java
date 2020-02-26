package com.company;

public class Paranthesis {

    char data;
    String type;

    public Paranthesis(char data) {
        this.data = data;
        this.type = "paranthesis";
    }

    public char getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return ""+data + ", " + type;
    }
}
