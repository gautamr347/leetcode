package org.example.stack;

public class Subsequence {

    public boolean isSubsequence(String s, String t) {

        int subLength = s.length();
        int strLength = t.length();
        int sCounter = 0;
        int tCounter = 0;
        while (sCounter < subLength){
            if(s.charAt(sCounter) == t.charAt(tCounter)){
                sCounter++;
                tCounter++;
            } else {
                tCounter++;
            }
            if(tCounter >= strLength && sCounter != subLength){
                return false;
            }
        }
        return true;
    }
}
