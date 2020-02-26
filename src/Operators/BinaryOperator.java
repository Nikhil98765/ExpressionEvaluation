package Operators;

public class BinaryOperator extends Operator {

    char[] BinaryOperators = {'+', '-', '*', '/'};


    public BinaryOperator(String data) {
        type = "BinaryOperator";
        this.data = data;

    }

    public BinaryOperator(){


    }



    public String getType(){
        return type;
    }

    public String getData() {
        return data;
    }

    public boolean isBinaryOperator(char token){
        for(int i = 0;i<BinaryOperators.length; i++){
            if(token == BinaryOperators[i]){
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "" + this.data + ", "+ this.type;
    }
}
