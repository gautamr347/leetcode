package org.example.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subset {

    //https://leetcode.com/problems/counting-words-with-a-given-prefix/?envType=daily-question&envId=2025-01-10

    public int prefixCount(String[] words, String pref) {
        int counter = 0;
        for(String str : words){
            if(str.indexOf(pref) == 0) counter++;
        }
        return counter;
    }

    private static int lastIndex(String str1, String str2){
        return str1.lastIndexOf(str2);
    }

    public static void main(String[] args) {
        System.out.println(lastIndex("abcde", "de"));
    }


}
