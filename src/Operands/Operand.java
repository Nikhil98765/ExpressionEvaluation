package Operands;

public class Operand {

    String type;
    String data;

    public Operand(String data) {
        this.type = "operand";
        this.data = data;
    }

    public Operand() {
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }


    @Override
    public String toString() {
        return "" + data + ", " + type;
    }
}
