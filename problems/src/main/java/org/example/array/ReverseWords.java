package org.example.array;

import java.util.Objects;
import java.util.Stack;

public class ReverseWords {

    public static String reverseWords(String s) {
        if(Objects.isNull(s) || s.isBlank()) return "";
        String[] splits = s.split(" ");
        Stack<String> stack = new Stack<>();
        for(String split : splits){
            if(split.isBlank()) continue;
            stack.add(split);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()){
            stringBuilder.append(" ").append(stack.pop());
        }
        return stringBuilder.toString().trim();

    }
}
