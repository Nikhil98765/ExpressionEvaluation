//package grammar;
//
//import com.company.Operand;
//import com.company.Paranthesis;
//
//import javax.naming.OperationNotSupportedException;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.Stack;
//
//public class ExpressionEvaluation {
//
//
//    public String evaluate(ArrayList<Object> tokens) {
//
//
//        Stack<Operand> operands = new Stack<Operand>();
//
//
//        Stack<Object> ops = new Stack<>();
//
//        for (int i = 0; i < tokens.size(); i++) {
//            Object token = tokens.get(i);
////            if(token instanceof Operand){
////                Operand tokenOperand = (Operand)token;
////            }else if(token instanceof UnaryOperator){
////                UnaryOperator unaryOperator = (UnaryOperator)token;
////            }else if(token instanceof BinaryOperator){
////                BinaryOperator binaryOperator = (BinaryOperator)token;
////            }
//
//            // Current token is a number, push it to stack for numbers
//            if (token instanceof Operand) {
//                operands.push((Operand) token);
//            }
//
//            // Current token is an opening brace, push it to 'ops'
//            else if (token instanceof Paranthesis)
//                if (((Paranthesis) token).data == '(') {
//                    ops.push(token);
//                } else {
//                    while (ops.peek() instanceof Paranthesis) {
//                        if (((Paranthesis) ops.peek()).data == '(') {
//                            operands.push(applyOp(ops.pop(), operands.pop(), operands.pop()));
//                            ops.pop();
//                        }
//                    }
//                }
//
//
//
//
//            // Current token is an operator.
//            else if (tokens[i] == '+' || tokens[i] == '-' ||
//                    tokens[i] == '*' || tokens[i] == '/') {
//                // While top of 'ops' has same or greater precedence to current
//                // token, which is an operator. Apply operator on top of 'ops'
//                // to top two elements in values stack
//                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
//                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
//
//                // Push current token to 'ops'.
//                ops.push(tokens[i]);
//            }
//        }
//
//        // Entire expression has been parsed at this point, apply remaining
//        // ops to remaining values
//        while (!ops.empty())
//            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
//
//        // Top of 'values' contains result, return it
//        return values.pop();
//    }
//
//    // Returns true if 'op2' has higher or same precedence as 'op1',
//    // otherwise returns false.
//    public static boolean hasPrecedence(char op1, char op2) {
//        if (op2 == '(' || op2 == ')')
//            return false;
//        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
//            return false;
//        else
//            return true;
//    }
//
//
//}


//    public static Operand applyOp(Object op, Object b, Object a)
//    {
////        switch (op)
////        {
////            case '+':
////                return a + b;
////            case '-':
////                return a - b;
////            case '*':
////                return a * b;
////            case '/':
////                if (b == 0)
////                    throw new
////                            UnsupportedOperationException("Cannot divide by zero");
////                return a / b;
////        }
////        return 0;
////    }
//}
