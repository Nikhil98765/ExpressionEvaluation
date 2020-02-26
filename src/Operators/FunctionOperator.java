package Operators;

public class FunctionOperator extends Operator {

    String[] functionOperators = new String[] {"sin", "cos", "tan","log"};

    public FunctionOperator(String data) {
        type = "FunctionOperator";
        this.data = data;

    }

    public FunctionOperator(){

    }

    public String[] getFunctionOperators() {
        return functionOperators;
    }

    public String getType(){
        return type;
    }

    public String getData() {
        return data;
    }

    public boolean isFunctionOperator(String token){
        for(int i = 0;i<functionOperators.length; i++){
            if(token.equals(functionOperators[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return ""+data +", " + type;
    }
}
