package com.company;

public class Paranthesis {

    char data;
    String type;

    public Paranthesis(char data) {
        this.data = data;
        this.type = "paranthesis";
    }

    @Override
    public String toString() {
        return ""+data + ", " + type;
    }
}
