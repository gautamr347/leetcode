package org.example.string;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportSpam {

    public static boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> setStr = Arrays.stream(message).collect(Collectors.toSet());
        int spamCounter = 0;
        for(String str : bannedWords){
            if(setStr.contains(str)){
                spamCounter++;
            }
            if(spamCounter >= 2){
                return true;
            }
        }
        return false;
    }

}
