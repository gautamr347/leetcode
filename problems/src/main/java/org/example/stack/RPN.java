package org.example.stack;

import java.util.Stack;

public class RPN {

    public static int evalRPN(String[] tokens) {
        Stack<String> operands = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                var firstElem = Integer.parseInt(operands.pop());
                var secondElem = Integer.parseInt(operands.pop());
                operands.add(String.valueOf(firstElem + secondElem));
            } else if(token.equals("-")){
                var firstElem = Integer.parseInt(operands.pop());
                var secondElem = Integer.parseInt(operands.pop());
                operands.add(String.valueOf(secondElem - firstElem));
            } else if(token.equals("*")){
                var firstElem = Integer.parseInt(operands.pop());
                var secondElem = Integer.parseInt(operands.pop());
                operands.add(String.valueOf(firstElem * secondElem));
            } else if (token.equals("/")){
                var firstElem = Integer.parseInt(operands.pop());
                var secondElem = Integer.parseInt(operands.pop());
                operands.add(String.valueOf(secondElem / firstElem));
            }else {
                operands.add(token);
            }
        }
        return Integer.parseInt(operands.pop());
    }

    public static void main(String[] args) {
        String[] arrs = {"4","13","5","/","+"};
        evalRPN(arrs);
    }
}
