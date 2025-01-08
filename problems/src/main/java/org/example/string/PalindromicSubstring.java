package org.example.string;

import java.util.HashMap;
import java.util.Map;

public class PalindromicSubstring {

    private static final Map<String, Boolean> stringPalindromeMap = new HashMap<>();

    public static String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        String palindrome= "";

        for(int i=0; i < s.length()-1; i++){
            for(int j=s.length(); j>i; j--){
                //substring already smaller than palindrome
                if(j-i < palindrome.length()){
                    break;
                }

                String sub = s.substring(i,j);
                boolean isPalindrome = false;
                if(stringPalindromeMap.containsKey(sub)){
                     isPalindrome = isPalindrome(sub);
                } else {
                    isPalindrome = isPalindrome(sub);
                    stringPalindromeMap.put(sub, isPalindrome);
                }
                if(isPalindrome){
                    if(sub.length() > palindrome.length()){
                        palindrome = sub;
                    }
                }
            }
        }
        return palindrome.length() <= 1? "" : palindrome;
    }

    private static boolean isPalindrome(String st){
        int i=0;
        int j=st.length()-1;
        while (i<j){
            if(st.charAt(i) == st.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String abc= "adbadf";
        System.out.println(longestPalindrome(abc));
    }
}
