package org.example.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class LetterCombinations {
    public static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2',List.of("a","b","c"));
        map.put('3',List.of("d","e","f"));
        map.put('4',List.of("g","h","i"));
        map.put('5',List.of("j","k","l"));
        map.put('6',List.of("m","n","o"));
        map.put('7',List.of("p","q","r","s"));
        map.put('8',List.of("t","u","v"));
        map.put('9',List.of("w","x","y","z"));
        letterCombinations(digits, 0, result, new StringBuilder(), map);
        return result;
    }

    private static void letterCombinations(String digits, int index, List<String> result, StringBuilder current, Map<Character, List<String>> map){
        if(digits.isEmpty() || index == digits.length()){
            var str = current.toString();
            if(!str.isEmpty()){
                result.add(str);
            }
            return;
        }
        char[] charArray = digits.toCharArray();
        for(int i = index; i < charArray.length; i++){
            char ch = charArray[i];
            List<String> llist = map.get(ch);
            for(String chi :llist){
                letterCombinations(digits, i + 1,result, current.append(chi), map);
                current = new StringBuilder();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
